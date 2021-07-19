package dyd.usizo.controller;

import dyd.usizo.accessingdatamysql.NeedRepository;
import dyd.usizo.accessingdatamysql.ShoppingListRepository;
import dyd.usizo.accessingdatamysql.UserRepository;
import dyd.usizo.models.Need;
import dyd.usizo.models.ShoppingList;
import dyd.usizo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;

@Controller
public class DashboardController extends HttpServlet {

    @Autowired
    private ShoppingListRepository shoppingListRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NeedRepository needRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        try {
            model.addAttribute("user",userRepository.findByNom( ((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
            return "dashboard";
        } catch (Exception e) {
            return "login";
        }
    }

    @GetMapping("/usizo")
    public String doGet(Model model){
        model.addAttribute("user",userRepository.findByNom( ((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()));
        return "dashboard";
    }

    @GetMapping("/getList")
    public String doGetList(@RequestParam(value = "id", defaultValue = "1") int id, Model model){
        model.addAttribute("sl", shoppingListRepository.findById(id).get());
        return "shopping-list-details";
    }

    @GetMapping("/addList")
    public String addList(@RequestParam(value = "id") int id,
                          Model model){
        User user = userRepository.findById(id).get();
        user.getShoppingLists().add(shoppingListRepository.save(new ShoppingList(user)));
        userRepository.save(user);
        return doGet(model);
    }

    @GetMapping("/remList")
    public String remList(@RequestParam(value = "id") int id,
                          @RequestParam(value = "idL") int idL,
                          Model model){
        User user = userRepository.findById(id).get();
        ShoppingList shoppingList = shoppingListRepository.findById(idL).get();
        shoppingList.getMembers().remove(user);
        user.getShoppingLists().remove(shoppingList);
        userRepository.save(user);
        if(shoppingListRepository.save(shoppingList).getMembers().isEmpty()){
            ArrayList<Need> needs = new ArrayList<>(shoppingList.getNeedList());
            shoppingList.setNeedList(new ArrayList<>());
            shoppingListRepository.save(shoppingList);
            for (Need need : needs) {
                needRepository.delete(need);
            }
            shoppingListRepository.delete(shoppingList);
        }
        return doGet(model);
    }

}
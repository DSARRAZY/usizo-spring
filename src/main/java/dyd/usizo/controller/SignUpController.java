package dyd.usizo.controller;

import dyd.usizo.accessingdatamysql.RoleRepository;
import dyd.usizo.accessingdatamysql.ShoppingListRepository;
import dyd.usizo.accessingdatamysql.UserRepository;
import dyd.usizo.models.ShoppingList;
import dyd.usizo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

@Controller
public class SignUpController extends HttpServlet {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShoppingListRepository shoppingListRepository;
    @GetMapping("/sign-up")
    public String showRegistrationForm(Model model) {

            return "sign-up";
    }

    @PostMapping("/sign-up")
    public String showRegistrationForm(@RequestParam(value = "username") String name,
                                       @RequestParam(value = "password1") String password1,
                                       @RequestParam(value = "password2") String password2,
                                       Model model) {
        if (password1.equals(password2)) {
            User user = new User(name,new BCryptPasswordEncoder().encode(password1),roleRepository.findById(2).get());
            userRepository.save(user);
            user.getShoppingLists().add(shoppingListRepository.save(new ShoppingList(user)));
            userRepository.save(user);
            model.addAttribute("success", "Inscription réussie");
            return "login";
        }else {
            model.addAttribute("error", "Les mots de passe ne correspondent pas");
            return "sign-up";
        }
    }
}

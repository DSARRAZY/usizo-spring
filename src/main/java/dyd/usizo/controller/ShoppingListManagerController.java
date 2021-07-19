package dyd.usizo.controller;

import dyd.usizo.accessingdatamysql.NeedRepository;
import dyd.usizo.accessingdatamysql.ProductRepository;
import dyd.usizo.accessingdatamysql.ShoppingListRepository;
import dyd.usizo.models.Need;
import dyd.usizo.models.Product;
import dyd.usizo.models.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ShoppingListManagerController extends HttpServlet {

    @Autowired
    private ShoppingListRepository shoppingListRepository;
    @Autowired
    private NeedRepository needRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/shoppingListManager")
    public String doGet(@RequestParam(value = "id", defaultValue = "6") int id, Model model){
        ShoppingList sl = shoppingListRepository.findById(id).get();
        model.addAttribute("sList", sl);
        List <Product> lp = (List<Product>) productRepository.findAll();
        model.addAttribute("products",lp);
        model.addAttribute("id",id);
        return "shopping-list-manager";
    }

    @PostMapping ("/shoppingListManager")
    public String doPost(@RequestParam(value = "id", defaultValue = "1") int id,
                         @RequestParam(value = "idP", defaultValue = "1") int idP,
                         @RequestParam(value = "number", defaultValue = "1") int number,
                         Model model){
        Need n = needRepository.findById(idP).get();
        n.setQuantity(number);
        needRepository.save(n);
        ShoppingList sl = shoppingListRepository.findById(id).get();
        model.addAttribute("sList", sl);
        return "ShoppingList";
    }

    @PostMapping ("/found")
    public String found(@RequestParam(value = "id", defaultValue = "1") int id,
                         @RequestParam(value = "idP", defaultValue = "1") int idP,
                         @RequestParam(value = "find", required = false) boolean find,
                         Model model){
        Need n = needRepository.findById(idP).get();
        if(find != n.isFounded())n.setFounded(find);
        needRepository.save(n);
        ShoppingList sl = shoppingListRepository.findById(id).get();
        model.addAttribute("sList", sl);
        return "shopping-list-manager";
    }

    @PostMapping ("/addNeed")
    public String addNeed(@RequestParam(value = "id", defaultValue = "6") int id,
                         @RequestParam(value = "idP", defaultValue = "1") int idP,
                         @RequestParam(value = "number", defaultValue = "1") int number,
                         Model model){
        ShoppingList sl = shoppingListRepository.findById(id).get();
        Product prod = productRepository.findById(idP).get();
        boolean in = false;
        for (Need n : sl.getNeedList())
        {
            if (n.getProduct() == prod)
            {
                in = true;
                n.setQuantity(n.getQuantity() + number);
                needRepository.save(n);
            }
        }
        if(!in)sl.getNeedList().add(needRepository.save(new Need(prod,number)));
        model.addAttribute("sList", shoppingListRepository.save(sl));
        return doGet(id,model);
    }

    @PostMapping ("/remNeed")
    public String remNeed(@RequestParam(value = "id", defaultValue = "6") int id,
                          @RequestParam(value = "idP", defaultValue = "1") int idP,
                          Model model){
        ShoppingList sl = shoppingListRepository.findById(id).get();
        Need n = needRepository.findById(idP).get();
        sl.getNeedList().remove(n);
        needRepository.delete(n);
        model.addAttribute("sList", shoppingListRepository.save(sl));
        return doGet(id,model);
    }

    @GetMapping("/ShopListProduct")
    public String doGetProduct(@RequestParam(value = "id", defaultValue = "1") int id,
                               @RequestParam(value = "sl", defaultValue = "1") int sl, Model model){
        model.addAttribute("sl",sl);
        model.addAttribute("need",needRepository.findById(id).get());
        return "ShoppingListProduct";
    }
}

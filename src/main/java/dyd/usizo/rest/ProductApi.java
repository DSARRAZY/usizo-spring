package dyd.usizo.rest;

import dyd.usizo.accessingdatamysql.ProductRepository;
import dyd.usizo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/product")
    public Optional<Product> getProduct(@RequestParam(value = "action", defaultValue = "find") String action, @RequestParam(value = "id", defaultValue = "0") int id) {
        if (action.equals("find")) return  productRepository.findById(id);
        else {
            productRepository.delete(productRepository.findById(id).get());
            return null;
        }
    }

    @PostMapping("/api/product")
    public Product addProduct(@RequestParam(value = "id", required = false, defaultValue = "-1") int id,
                              @RequestParam(value = "name", required = true, defaultValue = "") String name,
                              @RequestParam(value = "url", required = true, defaultValue = "") String imgUrl,
                              @RequestParam(value = "type", required = true, defaultValue = "") String type) {
        if(id == -1){
            return  productRepository.save(new Product(name,imgUrl,type));
        } else if (productRepository.existsById(id)){
            Product p = productRepository.findById(id).get();
            p.setType(type);
            p.setNom(name);
            p.setImgUrl(imgUrl);
            return  productRepository.save(p);
        }
        return null;
    }

    @GetMapping("/api/products")
    public Iterable<Product> getProducts() {
        if (!productRepository.findAll().iterator().hasNext()){
            List<Product> lp = new ArrayList<>();
            lp.add(new Product("Nutella", "", "Alimentation"));
            lp.add(new Product("Shampoo", "", "Hygiene"));
            productRepository.saveAll(lp);
        }
        return productRepository.findAll();
    }

}

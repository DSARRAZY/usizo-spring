package dyd.usizo.accessingdatamysql;

import dyd.usizo.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}

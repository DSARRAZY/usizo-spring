package dyd.usizo.accessingdatamysql;

import dyd.usizo.models.ShoppingList;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer> {

}

package dyd.usizo.accessingdatamysql;

import dyd.usizo.models.Need;
import dyd.usizo.models.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NeedRepository extends CrudRepository<Need, Integer> {

}

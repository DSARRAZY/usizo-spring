package dyd.usizo.accessingdatamysql;

import dyd.usizo.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
}

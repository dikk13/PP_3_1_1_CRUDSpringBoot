package PP_3_1_1_CRUDSpringBoot.userRepository;

import PP_3_1_1_CRUDSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

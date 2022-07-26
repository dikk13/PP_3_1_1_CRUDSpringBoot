package PP_3_1_1_CRUDSpringBoot.userRepository;

import PP_3_1_1_CRUDSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

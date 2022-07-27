package PP_3_1_1_CRUDSpringBoot.service;

import PP_3_1_1_CRUDSpringBoot.model.User;
import PP_3_1_1_CRUDSpringBoot.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

   private final UserRepository userRepository;
   @Autowired
   public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

   @Transactional
   public void add(User user) {
      userRepository.save(user);
   }

   @Transactional
   public void delete(int id) {
      userRepository.deleteById(id);
   }
   @Transactional
   public void update(int id, User user) {
      User user1 = userRepository.findById(id).orElse(new User());
      user1.setId(user.getId());
      user1.setFirstName(user.getFirstName());
      user1.setLastName(user.getLastName());
      user1.setEmail(user.getEmail());
      userRepository.saveAndFlush(user1);
   }

   @Transactional
   public User getUser(int id) {
      return userRepository.findById(id).orElse(null);
   }

   @Transactional(readOnly = true)
   public List<User> listUsers() {
      return userRepository.findAll();
   }

}

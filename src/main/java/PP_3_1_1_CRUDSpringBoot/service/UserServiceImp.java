package PP_3_1_1_CRUDSpringBoot.service;

import PP_3_1_1_CRUDSpringBoot.model.User;
import PP_3_1_1_CRUDSpringBoot.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

   private final UserRepository userRepository;
   @Autowired
   public UserServiceImp(UserRepository userRepository) {this.userRepository = userRepository;}

   @Transactional
   @Override
   public void add(User user) {
      userRepository.save(user);
   }

   @Transactional
   @Override
   public void delete(int id) {
      userRepository.deleteById(id);

   }@Transactional
   @Override
   public void update(int id, User user) {
      User userUpdate = userRepository.findById(id).get();
      userUpdate.setFirstName(user.getFirstName());
      userUpdate.setLastName(user.getLastName());
      userUpdate.setEmail(user.getEmail());
      userRepository.save(userUpdate);
   }

   @Transactional
   @Override
   public User getUser(int id) {
      return userRepository.findById(id).get();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return (List<User>) userRepository.findAll();
   }

}

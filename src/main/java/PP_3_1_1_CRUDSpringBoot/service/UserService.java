package PP_3_1_1_CRUDSpringBoot.service;

import PP_3_1_1_CRUDSpringBoot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(int id, User user);
    User getUser(int id);
    List<User> listUsers();
}

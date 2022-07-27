package PP_3_1_1_CRUDSpringBoot.controller;

import PP_3_1_1_CRUDSpringBoot.model.User;
import PP_3_1_1_CRUDSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {this.userService = userService;}

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/users";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute ("user") User user, @PathVariable int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}


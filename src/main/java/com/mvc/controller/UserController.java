package com.mvc.controller;

import com.mvc.model.User;
import com.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        userService.saveUser(new User("testfirstname", "testlastname1",  1));
        userService.saveUser(new User("testfirstname1", "testlastname2",  2));
        userService.saveUser(new User("testfirstname2", "testlastname3", 3));
        userService.saveUser(new User("testfirstname3", "testlastname4",  4));
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newUser";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @RequestMapping("/editUser")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.editUser(id, user);
        return "redirect:/users";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}

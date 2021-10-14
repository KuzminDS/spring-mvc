package com.ssu.kuzmin.mvc.controller;

import com.ssu.kuzmin.mvc.entities.User;
import com.ssu.kuzmin.mvc.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/user-list", method=RequestMethod.GET)
    public String getUserListPage(Model model) {
        model.addAttribute("userList",userService.getAll());
        return "user_list";
    }

    @RequestMapping(value="/add-user", method=RequestMethod.GET)
    public String getAddUserPage(Model model) {
        return "add_user";
    }

    @RequestMapping(value="/add-user-post", method=RequestMethod.POST)
    public String addUser(@RequestParam(value="firstName") String firstName,
                               @RequestParam(value="lastName") String lastName,
                               @RequestParam(value="patronymic") String patronymic,
                               @RequestParam(value="number") String number,
                               @RequestParam(value="email") String email,
                               @RequestParam(value="password") String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setNumber(number);
        user.setEmail(email);
        user.setPassword(password);
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping(value="/update-user", method=RequestMethod.GET)
    public String getUpdateUserPage(Model model) {
        return "update_user";
    }

    @RequestMapping(value="/update-user-post", method=RequestMethod.POST)
    public String updateUser(@RequestParam(value="id") int id,
                             @RequestParam(value="firstName") String firstName,
                             @RequestParam(value="lastName") String lastName,
                             @RequestParam(value="patronymic") String patronymic,
                             @RequestParam(value="number") String number,
                             @RequestParam(value="email") String email,
                             @RequestParam(value="password") String password) throws Exception {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPatronymic(patronymic);
        user.setNumber(number);
        user.setEmail(email);
        user.setPassword(password);
        userService.update(user);
        return "redirect:/";
    }

    @RequestMapping(value="/delete-user", method=RequestMethod.GET)
    public String getDeleteUserPage(Model model) {
        return "delete_user";
    }

    @RequestMapping(value="/delete-user-post", method=RequestMethod.POST)
    public String deleteUser(@RequestParam(value="id") int id) throws Exception {
        userService.delete(id);
        return "redirect:/";
    }
}

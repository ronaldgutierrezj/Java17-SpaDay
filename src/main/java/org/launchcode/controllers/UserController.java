package org.launchcode.controllers;


import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAllUsers(Model model) {
        model.addAttribute("title", "All Users");
        model.addAttribute("users", UserData.getAll());

        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm() {

        return "user/add";
    }

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User newUser, String verify) {
        if(newUser.getPassword().equals(verify)){
            UserData.add(newUser);
            model.addAttribute("user", newUser );
            model.addAttribute("verify", verify );
            return "user/index";
        } else {
            model.addAttribute("user", newUser );
            model.addAttribute("error", "password do not match" );
            return "user/add";
        }
    }

    @GetMapping("/{id}")
    public String displayUserDetails(@PathVariable int id, Model model){
        model.addAttribute("user", UserData.getById(id));
        return "user/usersInfo";
    }

}

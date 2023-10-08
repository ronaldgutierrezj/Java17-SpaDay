package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")

public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model){
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify, Errors errors){
        if(verify.equals(user.getPassword())){
            return "user/index";
        } else{
            model.addAttribute("errors","passwords do not match");
            return "user/add";

        }


    }

}

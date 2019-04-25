package com.foodies.foodies.Controllers;

import com.foodies.foodies.Models.User;
import com.foodies.foodies.Models.UserRepository;
import com.foodies.foodies.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String createUser(@RequestBody User user, Model model){
        System.out.println(user.toString());
        User newUser = userService.createUser(user);
        model.addAttribute("user", newUser);
//       return ResponseEntity.ok(newUser);
        return "user";
    }
}

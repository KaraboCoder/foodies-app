package com.foodies.foodies.Controllers;

import com.foodies.foodies.Models.Users;
import com.foodies.foodies.Models.UsersRepository;
import com.foodies.foodies.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {
    @Autowired
    UsersService usersService;

    @PostMapping("/user")
    public String createUser(@RequestBody Users user, Model model){
        System.out.println(user.toString());
        Users newUser = usersService.createUser(user);
        model.addAttribute("user", newUser);
//       return ResponseEntity.ok(newUser);
        return "user";
    }
}

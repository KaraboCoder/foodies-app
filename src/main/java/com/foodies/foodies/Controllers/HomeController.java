package com.foodies.foodies.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @GetMapping("")
    public  String HomePageView(Model model){
        model.addAttribute("message", "Thymeleaf is f**n awsome!");
        model.addAttribute("umessage", "<b>Thymeleaf is here!</b>");
        return "index";
    }
}

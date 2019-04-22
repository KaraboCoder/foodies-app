package com.foodies.foodies.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    public String IndexPage(Model model){
        model.addAttribute("title", "Home");
        return "index";
    }
}

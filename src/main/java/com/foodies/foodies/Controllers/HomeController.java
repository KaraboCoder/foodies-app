package com.foodies.foodies.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("")
    public  String HomePageView(Model model){
        return "index";
    }
}

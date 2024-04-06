package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String renderHomePage(Model model) {
        model.addAttribute("headingText", "Welcome");
        return "index";
    }

}

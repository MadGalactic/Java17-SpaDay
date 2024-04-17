package org.launchcode.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String renderHomePage(Model model) {
//        model.addAttribute("headingText", "Welcome");
//        return "index";
//    }
    @GetMapping("/")
    public String redirectHomePage() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String renderHomePage(Model model, HttpSession session) {
        model.addAttribute("loggedIn", session.getAttribute("user") != null);
        return "index";
    }

}

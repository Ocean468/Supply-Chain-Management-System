package com.supplychain.supply_chain_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Display login page
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // maps to login.jsp
    }

    // Display signup page
    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("user", new AppUser());
        return "signup"; // maps to signup.jsp
    }

    // Process signup form
    @PostMapping("/signup")
    public String processSignup(@ModelAttribute("user") AppUser user, Model model) {
        if (userService.findByUsername(user.getUsername()) != null) {
            model.addAttribute("error", "Username already exists!");
            return "signup";
        }
        userService.save(user);
        return "redirect:/login?signupSuccess";
    }

    // Dashboard page (protected)
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // maps to dashboard.jsp
    }
}









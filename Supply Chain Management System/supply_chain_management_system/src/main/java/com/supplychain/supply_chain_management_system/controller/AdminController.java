package com.supplychain.supply_chain_management_system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.supplychain.supply_chain_management_system.model.AppUser;
import com.supplychain.supply_chain_management_system.service.UserService;

@Controller
public class AdminController {

    
    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    public String viewAllUsers(Model model) {
        List<AppUser> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin_users"; // JSP page to list users
    }
}


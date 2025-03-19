package com.ppds07.EMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage()
    {
        System.out.println("REached login");
        return "login";
    }

    @GetMapping("/dashboard")
    public String showDashboard()
    {
        System.out.println("reached dashboard");
        return "dashboard";
    }

}

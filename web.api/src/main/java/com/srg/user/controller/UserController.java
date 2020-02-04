package com.srg.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("modify")
    public String modify(Model model) {
        return "modify";
    }

    @GetMapping("mypage")
    public String mypage(Model model) {
        return "mypage";
    }

    @GetMapping("withdrawal")
    public String withdrawal(Model model) {
        return "withdrawal";
    }
}

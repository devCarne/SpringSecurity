package com.example.springsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody
    String root() throws Exception {
        return "index";
    }

    @RequestMapping("/guest/welcome")
    public String welcomeGuest() {
        return "guest/welcome1";
    }

    @RequestMapping("/member/welcome")
    public String welcomeMember() {
        return "member/welcome2";
    }

    @RequestMapping("/admin/welcome")
    public String welcomeAdmin() {
        return "admin/welcome3";
    }

    @RequestMapping("/loginForm")
    public String loginForm() {
        return "security/loginForm";
    }

    @RequestMapping("/loginError")
    public String loginError() {
        return "security/loginError";
    }
}

package com.tang.telecom.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author weepppp 2022/7/8 16:12
 **/
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/dologin")
    public String dologin(String username, String password, Model model, String rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            if ("on".equals(rememberMe)) {
                usernamePasswordToken.setRememberMe(true);
            }
            subject.login(usernamePasswordToken);
            return "redirect:/index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }
        return "forward:/login";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/account")
    public String account(){
        return "account";
    }

    @GetMapping("/customer")
    public String customer(){
        return "customer";
    }

    @GetMapping("/phone")
    public String phone(){
        return "phone";
    }

    @GetMapping("/bill")
    public String bill(){
        return "bill";
    }

    @GetMapping("/billClient")
    public String billClient(){
        return "billClient";
    }


}

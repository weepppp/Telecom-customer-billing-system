package com.tang.telecom.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author weepppp 2022/7/8 16:12
 **/
@Controller
public class LoginController {

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


}

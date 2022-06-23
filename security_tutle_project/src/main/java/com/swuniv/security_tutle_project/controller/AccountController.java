package com.swuniv.security_tutle_project.controller;


import com.swuniv.security_tutle_project.request.PasswordRequest;
import com.swuniv.security_tutle_project.request.SignUpRequest;
import com.swuniv.security_tutle_project.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegisterUser(@ModelAttribute SignUpRequest signUpRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register";
        }
        accountService.doSignUp(signUpRequest);
        return "redirect:/";
    }

    @GetMapping("/modify")
    public String modifyPassword(){
        return "modify-form";
    }

    @PostMapping("/modify")
    public String doModifyPassword(@ModelAttribute PasswordRequest passwordRequest, HttpServletRequest httpServletRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "modify";
        }
        HttpSession session = httpServletRequest.getSession(false);
        accountService.updateUserPassword((String) session.getAttribute("id"),passwordRequest);
        return "redirect:/";
    }

}

package com.swuniv.security_tutle_project.controller;

import com.swuniv.security_tutle_project.request.CipherRequest;
import com.swuniv.security_tutle_project.response.CipherResponse;
import com.swuniv.security_tutle_project.service.CipherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CipherController {
    private final CipherService cipherService;

    @GetMapping("/cipher")
    public String findUserCipherList(HttpServletRequest httpServletRequest, ModelMap modelMap){
        HttpSession session = httpServletRequest.getSession(false);
        String userId = (String) session.getAttribute("id");
        List<CipherResponse> cipherLists = cipherService.findRegisterCipherList(userId);
        modelMap.addAttribute("lists",cipherLists);
        return "cipher";
    }

    @GetMapping("/cipher/create")
    public String createCipher(ModelMap modelMap){

        return "passCreate";
    }

    @PostMapping("/create")
    public String doCreateCipher(@ModelAttribute CipherRequest cipherRequest, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(false);
        String userId = (String) session.getAttribute("id");
        cipherService.createCipher(userId, cipherRequest);
        return "redirect:/";
    }
}

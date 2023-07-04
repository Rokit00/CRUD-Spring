package com.Semi_Projrct.Ciyt.controller;

import com.Semi_Projrct.Ciyt.dto.UserDTO;
import com.Semi_Projrct.Ciyt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class userController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signupForm() {return  "signup";}

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserDTO userDTO) {
        System.out.println("userController.signup");
        System.out.println("userDTO = " + userDTO);
        userService.signup(userDTO);
        return "login";
    }

    @GetMapping("/login")
    public String loginForm() { return  "login"; }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, HttpSession session) {
        UserDTO loginResult = userService.login(userDTO);
        if (loginResult != null){
            // login 성공
            session.setAttribute("loginEmail", loginResult.getUserEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }

}

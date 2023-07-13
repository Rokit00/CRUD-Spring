package com.Semi_Projrct.Ciyt.service;

import com.Semi_Projrct.Ciyt.controller.MemberForm;
import com.Semi_Projrct.Ciyt.domain.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class SigninController {
    private final MemberService memberService;

    private final PostService postService;

    @Autowired
    public SigninController(MemberService memberService, PostService postService) {
        this.postService = postService;
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "signup";
    }

    @PostMapping("/signup")
    public String create(MemberForm form) {

        memberService.createMember(
                form.getUsername(),
                form.getPassword(),
                form.getNickname(),
                form.getEmail()
        );
        return "redirect:/login";
    }
}

  
package com.Semi_Projrct.Ciyt.controller;


import com.Semi_Projrct.Ciyt.domain.Member;
import com.Semi_Projrct.Ciyt.service.MemberService;
import com.Semi_Projrct.Ciyt.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class PostDelecteController {

    private PostService postService;

    private MemberService memberService;

    public PostDelecteController(PostService postService, MemberService memberService) {
        this.postService = postService;
        this.memberService = memberService;
    }

    @PostMapping("/delete-post")
    public String deletePost(@RequestParam("postId") Long postId) {
        postService.deletePost(postId);
        return "redirect:/";
    }
}

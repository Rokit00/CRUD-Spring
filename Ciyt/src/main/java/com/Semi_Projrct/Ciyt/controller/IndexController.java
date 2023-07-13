package com.Semi_Projrct.Ciyt.controller;

import com.Semi_Projrct.Ciyt.domain.Post;
import com.Semi_Projrct.Ciyt.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    private final PostService postService;

    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        String nickname = (String) session.getAttribute("nickname");
        model.addAttribute("nickname", nickname);
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}

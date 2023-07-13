package com.Semi_Projrct.Ciyt.controller;


import com.Semi_Projrct.Ciyt.domain.Member;
import com.Semi_Projrct.Ciyt.domain.Post;
import com.Semi_Projrct.Ciyt.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/login/post")
    public String createPost(@RequestParam("content") String content, @RequestParam(value = "nickname", required = false) String nickname, HttpSession session) {
        // 글 작성 로직 구현
        // content와 nickname을 사용하여 글 작성 처리

        String user = (String) session.getAttribute("nickname");

        if(user == null) {
            Post post = new Post();
            post.setContent(content);
            post.setAnonymous(nickname);
            post.setCreatedAt(LocalDateTime.now());
            postService.Postsave(post);

            System.out.println("로그인 안하고 저장 성공");
        }else{
            Post post = new Post();
            post.setContent(content);
            post.setNickname(nickname);
            post.setCreatedAt(LocalDateTime.now());
            postService.Postsave(post);
            System.out.println("로그인 해서 저장 성공");
        }

        return "redirect:/";
    }

    // 게시글 수정 요청 처리
    @PostMapping("/update-post")
    public String updatePost(@RequestParam Long postId, @RequestParam String content) {
        postService.updatePost(postId, content);
        return "redirect:/"; // 수정 후 index 페이지로 리다이렉트
    }



    @GetMapping("/post")
    public String showPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        Collections.reverse(posts); // Reverse the order of the posts list
        model.addAttribute("posts", posts);
        return "redirect:/";
    }
}

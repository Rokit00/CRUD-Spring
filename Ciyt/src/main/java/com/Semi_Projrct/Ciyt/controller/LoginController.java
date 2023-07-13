package com.Semi_Projrct.Ciyt.controller;

import com.Semi_Projrct.Ciyt.domain.Member;
import com.Semi_Projrct.Ciyt.domain.Post;
import com.Semi_Projrct.Ciyt.service.MemberService;
import com.Semi_Projrct.Ciyt.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    private final MemberService memberService;

    private final PostService postService;

    public LoginController(MemberService memberService, PostService postService) {
        this.memberService = memberService;
        this.postService = postService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "login";
    }


    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String userName, @RequestParam("userpassword") String userPassword, Model model, HttpSession session)
    {
//         아이디와 비밀번호 검증
        if (memberService.isValidUser(userName, userPassword)) {
            System.out.println("로그인 성공");
            // 로그인 성공 시 index로
            Member member = memberService.getMemberByUsername(userName);
            session.setAttribute("nickname", member.getNickname());
            model.addAttribute("nickname", member.getNickname());
            List<Post> posts = postService.getAllPosts();
            model.addAttribute("posts", posts);
            return "redirect:/";
        } else {
            // 로그인 실패 시 "errer" 키가 타임리프 구현한 페이지로 넘어감
            List<Post> posts = postService.getAllPosts();
            model.addAttribute("posts", posts);
            System.out.println("로그인 실패");
            model.addAttribute("error", "아이디나 비밀번호가 틀렸습니다.");
            return "login";
        }
    }


    @GetMapping("/index")
    public String showIndexPage(Model model, HttpSession session) {
        String nickname = (String) session.getAttribute("nickname");

        model.addAttribute("nickname", nickname);

        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Clear the session attributes
        session.invalidate();
        return "redirect:/"; // Redirect to the login page after logout
    }

}

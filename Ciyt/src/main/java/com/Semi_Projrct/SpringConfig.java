package com.Semi_Projrct;


import com.Semi_Projrct.Ciyt.repository.MemberRepository;
import com.Semi_Projrct.Ciyt.repository.PostRepository;
import com.Semi_Projrct.Ciyt.service.MemberService;
import com.Semi_Projrct.Ciyt.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private MemberRepository memberRepository;
    private PostRepository postRepository;


    public SpringConfig(MemberRepository memberRepository,PostRepository postRepository) {
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository);
    }

}

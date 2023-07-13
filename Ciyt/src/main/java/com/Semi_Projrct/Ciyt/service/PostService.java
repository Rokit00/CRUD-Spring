package com.Semi_Projrct.Ciyt.service;


import com.Semi_Projrct.Ciyt.domain.Post;
import com.Semi_Projrct.Ciyt.repository.PostRepository;

import java.util.List;

public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void Postsave(Post post) {
        // Add any necessary validations or business logic here before saving

        // Save the post to the database
        postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        // Retrieve the posts from your data source
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        return posts;
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    // 게시글 수정
    public void updatePost(Long postId, String content) {
        // 1. 선택된 게시물을 식별합니다.
        Post existingPost = postRepository.findById(postId).orElseThrow(()
                -> new PostNotFoundException("게시글을 찾을 수 없습니다."));

        // 2. 선택된 게시물의 content 값을 새로운 값으로 업데이트합니다.
        existingPost.setContent(content);

        // 3. 업데이트된 게시물을 저장합니다.
        postRepository.save(existingPost);
    }
    // 사용자 정의 예외
    public class PostNotFoundException extends RuntimeException {
        public PostNotFoundException(String message) {
            super(message);
        }
    }
}



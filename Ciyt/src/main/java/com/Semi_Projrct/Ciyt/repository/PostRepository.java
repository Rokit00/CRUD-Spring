package com.Semi_Projrct.Ciyt.repository;

import com.Semi_Projrct.Ciyt.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post save(Post post);

    List<Post> findAll();

    List<Post> findAllByOrderByCreatedAtDesc();
}

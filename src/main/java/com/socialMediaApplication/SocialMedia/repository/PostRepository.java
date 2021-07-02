package com.socialMediaApplication.SocialMedia.repository;

import com.socialMediaApplication.SocialMedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findPostByIdAndIsActiveTrue(Long postId);

    List<Post> findAllByIsActiveTrue();
}

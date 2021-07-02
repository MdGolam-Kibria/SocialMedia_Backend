package com.socialMediaApplication.SocialMedia.service;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.dto.PostDto;

public interface PostService {
    Response createPost(PostDto postDto);

    Response updatePost(PostDto postDto);

    Response deletePost(Long id);

    Response getAllPost();
}

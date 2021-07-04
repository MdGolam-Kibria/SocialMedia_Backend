package com.socialMediaApplication.SocialMedia.controller;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.annotation.ApiController;
import com.socialMediaApplication.SocialMedia.annotation.ValidateData;
import com.socialMediaApplication.SocialMedia.dto.PostDto;
import com.socialMediaApplication.SocialMedia.service.PostService;
import com.socialMediaApplication.SocialMedia.util.UrlConstraint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.PostManagement.ROOT)
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ValidateData
    @PostMapping(UrlConstraint.PostManagement.CREATE)
    public Response createPost(@RequestBody @Valid PostDto postDto, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        return postService.createPost(postDto);
    }

    @ValidateData
    @PutMapping(UrlConstraint.PostManagement.UPDATE)
    public Response updatePost(@RequestBody @Valid PostDto postDto, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        return postService.updatePost(postDto);
    }

    @DeleteMapping(UrlConstraint.PostManagement.DELETE)
    public Response deletePost(@PathVariable("id") Long id,HttpServletRequest request, HttpServletResponse response) {
        return postService.deletePost(id);
    }

    @GetMapping(UrlConstraint.PostManagement.GET_ALL)
    public Response getAllPost() {
        return postService.getAllPost();
    }
}

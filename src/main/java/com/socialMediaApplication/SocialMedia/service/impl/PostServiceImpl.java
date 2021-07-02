package com.socialMediaApplication.SocialMedia.service.impl;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.View.ResponseBuilder;
import com.socialMediaApplication.SocialMedia.dto.PostDto;
import com.socialMediaApplication.SocialMedia.model.Post;
import com.socialMediaApplication.SocialMedia.repository.PostRepository;
import com.socialMediaApplication.SocialMedia.service.PostService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("postService")
public class PostServiceImpl implements PostService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }

    @Override
    public Response createPost(PostDto postDto) {
        try {
            Post currentPost = modelMapper.map(postDto, Post.class);
            currentPost = postRepository.save(currentPost);
            if (currentPost != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, "Post Creation Successfully", currentPost);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @Override
    public Response updatePost(PostDto postDto) {
        try {
            Optional<Post> postOptional = postRepository.findPostByIdAndIsActiveTrue(postDto.getId());
            if (!postOptional.isPresent()) {
                return ResponseBuilder.getFailureResponse(HttpStatus.NO_CONTENT, "Didn't Find Any Post With This Id");
            }
            Post post = postOptional.get();
            post = modelMapper.map(postDto, post.getClass());
            post = postRepository.save(post);
            if (post != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Post Successfully Updated", post);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @Override
    public Response deletePost(Long id) {
        try {
            Optional<Post> postOptional = postRepository.findPostByIdAndIsActiveTrue(id);
            if (!postOptional.isPresent()) {
                return ResponseBuilder.getFailureResponse(HttpStatus.NO_CONTENT, "Didn't Find Any Post With This Id");
            }
            Post currentPost = postOptional.get();
            postRepository.delete(currentPost);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Completely Deleted", null);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @Override
    public Response getAllPost() {
        try {
            List<Post> postList = postRepository.findAllByIsActiveTrue();
            return postList.isEmpty()
                    ?
                    ResponseBuilder.getFailureResponse(HttpStatus.NO_CONTENT, "Didn't find Any Post !")
                    :
                    ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Post Retrieve Successfully", postList);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}

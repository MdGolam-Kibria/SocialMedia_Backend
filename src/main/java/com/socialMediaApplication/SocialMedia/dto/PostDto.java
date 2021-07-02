package com.socialMediaApplication.SocialMedia.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PostDto {
    private Long id;
    @NotEmpty(message = "Post shouldn't be empty")
    private String post;
    @Valid
    @NotNull(message = "Location is Required")
    private LocationDto location;
    @NotNull(message = "is Public or Not Is Mandatory")
    private Boolean isPublic;
}

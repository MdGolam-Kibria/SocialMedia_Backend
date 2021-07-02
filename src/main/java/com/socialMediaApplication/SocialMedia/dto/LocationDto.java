package com.socialMediaApplication.SocialMedia.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LocationDto {
    private Long id;
    @NotEmpty(message = "Location Name Mandatory")
    private String location;
}

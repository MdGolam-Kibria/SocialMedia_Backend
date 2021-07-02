package com.socialMediaApplication.SocialMedia.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Location extends BaseModel {
    private String location;
}

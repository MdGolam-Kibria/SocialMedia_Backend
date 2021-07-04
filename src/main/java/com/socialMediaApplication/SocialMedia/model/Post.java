package com.socialMediaApplication.SocialMedia.model;

import com.socialMediaApplication.SocialMedia.util.SecurityUtl;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;

@Data
@Entity
public class Post extends BaseModel {
    private String post;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Location location;
    private Boolean isPublic;
    @Column(updatable = false)
    private Long userId;
    @Column(updatable = false)
    private String userName;


    @PrePersist
    public void insertCurrentUserId() {
        this.userId = SecurityUtl.getLoggedUserId();
        this.userName = SecurityUtl.getLoggedUserName();
    }
}

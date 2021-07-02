package com.socialMediaApplication.SocialMedia.util;

import com.socialMediaApplication.SocialMedia.dto.UserPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtl {

    private SecurityUtl() {
    }

    public static Long getLoggedUserId() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userPrincipal != null ? userPrincipal.getId() : null;
    }
}

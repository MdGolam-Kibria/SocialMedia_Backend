package com.socialMediaApplication.SocialMedia.service;
import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.dto.LoginDto;
import com.socialMediaApplication.SocialMedia.dto.UserDto;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    Response login(LoginDto loginDto, HttpServletRequest request);
    Response createUserAccount(UserDto userDto, BindingResult result, HttpServletRequest request);
}

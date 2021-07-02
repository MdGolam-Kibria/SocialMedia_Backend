package com.socialMediaApplication.SocialMedia.controller;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.annotation.ApiController;
import com.socialMediaApplication.SocialMedia.annotation.ValidateData;
import com.socialMediaApplication.SocialMedia.dto.LoginDto;
import com.socialMediaApplication.SocialMedia.dto.UserDto;
import com.socialMediaApplication.SocialMedia.service.AuthService;
import com.socialMediaApplication.SocialMedia.util.UrlConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.AuthManagement.ROOT)
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ValidateData
    @PostMapping(UrlConstraint.AuthManagement.LOGIN)
    public Response login(@RequestBody @Valid LoginDto loginDto, BindingResult result, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return authService.login(loginDto, httpServletRequest);
    }

    @ValidateData
    @PostMapping(UrlConstraint.UserManagement.CREATE_USER)
    public Response createUser(@RequestBody @Valid UserDto userDto, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        return authService.createUserAccount(userDto, bindingResult, request);
    }

}

package com.socialMediaApplication.SocialMedia.service;


import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.dto.UserDto;
import com.socialMediaApplication.SocialMedia.model.User;


public interface UserService {
    Response createUser(UserDto userDto);

    User getUserByPhone(String phone);

    Response getAllUsers();
}

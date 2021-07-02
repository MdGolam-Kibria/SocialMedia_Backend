package com.socialMediaApplication.SocialMedia.service.impl;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.dto.UserDto;
import com.socialMediaApplication.SocialMedia.model.User;
import com.socialMediaApplication.SocialMedia.repository.UserRepository;
import com.socialMediaApplication.SocialMedia.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Response createUser(UserDto userDto) {
        return null;
    }

    @Override
    public User getUserByPhone(String phone) {
        return userRepository.findByPhoneAndIsActiveTrue(phone);
    }

    @Override
    public Response getAllUsers() {
        return null;
    }
}

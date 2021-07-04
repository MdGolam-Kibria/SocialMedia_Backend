package com.socialMediaApplication.SocialMedia.service.impl;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.View.ResponseBuilder;
import com.socialMediaApplication.SocialMedia.dto.LoginDto;
import com.socialMediaApplication.SocialMedia.dto.LoginResponseDto;
import com.socialMediaApplication.SocialMedia.dto.UserDto;
import com.socialMediaApplication.SocialMedia.filter.JwtTokenProvider;
import com.socialMediaApplication.SocialMedia.model.User;
import com.socialMediaApplication.SocialMedia.repository.RoleRepository;
import com.socialMediaApplication.SocialMedia.repository.UserRepository;
import com.socialMediaApplication.SocialMedia.service.AuthService;
import com.socialMediaApplication.SocialMedia.util.SecurityUtl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("authService")
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public AuthServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, PasswordEncoder passwordEncoder, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Response login(LoginDto loginDto, HttpServletRequest request) {
        User user = userRepository.findByPhoneAndIsActiveTrue(loginDto.getPhone());
        if (user == null) {
            return ResponseBuilder.getFailureResponse(HttpStatus.UNAUTHORIZED, "Invalid Phone or Password");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getPhone(), loginDto.getPassword()));
        if (authentication.isAuthenticated()) {
            LoginResponseDto loginResponseDto = new LoginResponseDto();
            loginResponseDto.setToken(jwtTokenProvider.generateToken(authentication, request));
            loginResponseDto.setUsername(user.getUsername());
            loginResponseDto.setUserId(userRepository.findByPhoneAndIsActiveTrue(loginDto.getPhone()).getId());
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Logged In Success", loginResponseDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.BAD_REQUEST, "Invalid Phone or Password");
    }

    @Override
    public Response createUserAccount(UserDto userDto, BindingResult result, HttpServletRequest request) {
        try {
            User user = modelMapper.map(userDto, User.class);
            user.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
            user.setCreatedAt(new Date());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user = userRepository.save(user);
            if (user != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, "Complete User Registration", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        } catch (Exception e) {
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}

package com.socialMediaApplication.SocialMedia.controller;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.annotation.ApiController;
import com.socialMediaApplication.SocialMedia.annotation.ValidateData;
import com.socialMediaApplication.SocialMedia.dto.LocationDto;
import com.socialMediaApplication.SocialMedia.service.LocationService;
import com.socialMediaApplication.SocialMedia.util.UrlConstraint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.LocationManagement.ROOT)
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ValidateData
    @PostMapping(UrlConstraint.LocationManagement.CREATE)
    public Response createLocation(@RequestBody @Valid LocationDto locationDto, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        return locationService.createLocation(locationDto);
    }

    @GetMapping(UrlConstraint.LocationManagement.GET)
    public Response getLocation(@PathVariable("id") Long id) {
        return locationService.getLocationById(id);
    }

    @GetMapping(UrlConstraint.LocationManagement.GET_ALL)
    public Response getAllLocation() {
        return locationService.getAllLocation();
    }
}

package com.socialMediaApplication.SocialMedia.service;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.dto.LocationDto;

public interface LocationService {
    Response createLocation(LocationDto locationDto);
    Response getAllLocation();
    Response getLocationById(Long locationId);
}

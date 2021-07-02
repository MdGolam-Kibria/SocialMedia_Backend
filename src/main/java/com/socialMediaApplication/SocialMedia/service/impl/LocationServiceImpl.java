package com.socialMediaApplication.SocialMedia.service.impl;

import com.socialMediaApplication.SocialMedia.View.Response;
import com.socialMediaApplication.SocialMedia.View.ResponseBuilder;
import com.socialMediaApplication.SocialMedia.dto.LocationDto;
import com.socialMediaApplication.SocialMedia.model.Location;
import com.socialMediaApplication.SocialMedia.repository.LocationRepository;
import com.socialMediaApplication.SocialMedia.service.LocationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("locationService")
public class LocationServiceImpl implements LocationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    public LocationServiceImpl(LocationRepository locationRepository, ModelMapper modelMapper) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response createLocation(LocationDto locationDto) {
        try {
            Location location = modelMapper.map(locationDto, Location.class);
            location = locationRepository.save(location);
            return location != null
                    ?
                    ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, "Location Creation Successfully", location)
                    :
                    ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }

    @Override
    public Response getAllLocation() {
        try {
            List<Location> locationList = locationRepository.findAllByIsActiveTrue();
            return !locationList.isEmpty()
                    ?
                    ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Location Retrieved Successfully", locationList)
                    :
                    ResponseBuilder.getFailureResponse(HttpStatus.NO_CONTENT, "Didn't Find Any Location");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }


    }

    @Override
    public Response getLocationById(Long locationId) {
        try {
            Optional<Location> locationOptional = locationRepository.findLocationByIdAndIsActiveTrue(locationId);
            return locationOptional.isPresent()
                    ?
                    ResponseBuilder.getSuccessResponse(HttpStatus.OK, "Location Retrieved Successfully", locationOptional.get())
                    :
                    ResponseBuilder.getFailureResponse(HttpStatus.NO_CONTENT, "Didn't Find Any Location With This Id");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}

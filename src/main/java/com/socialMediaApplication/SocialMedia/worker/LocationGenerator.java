package com.socialMediaApplication.SocialMedia.worker;

import com.socialMediaApplication.SocialMedia.model.Location;
import com.socialMediaApplication.SocialMedia.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class LocationGenerator {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final LocationRepository locationRepository;

    public LocationGenerator(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @PostConstruct
    public void generateLocation() {
        List<String> locationList
                = Arrays.asList("Dhaka", "Naogaon", "Dhanmondi", "Saver", "Paltan");
        try {
            List<Location> currentLocationList = new ArrayList<>();
            locationList.forEach(currentLocation -> {
                Location location = new Location();
                location.setLocation(currentLocation);
                currentLocationList.add(location);
            });
            locationRepository.saveAll(currentLocationList);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

}

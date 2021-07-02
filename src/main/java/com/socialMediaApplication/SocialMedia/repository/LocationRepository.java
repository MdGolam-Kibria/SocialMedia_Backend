package com.socialMediaApplication.SocialMedia.repository;

import com.socialMediaApplication.SocialMedia.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByIsActiveTrue();

    Optional<Location> findLocationByIdAndIsActiveTrue(Long id);
}

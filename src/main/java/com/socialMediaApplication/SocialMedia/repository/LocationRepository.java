package com.socialMediaApplication.SocialMedia.repository;

import com.socialMediaApplication.SocialMedia.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByIsActiveTrue();

    Optional<Location> findLocationByIdAndIsActiveTrue(Long id);

    @Query(value = "SELECT * FROM brain_station_23.location where location.location like %:key%", nativeQuery = true)
    List<Location> findByLocationLikeAndIsActiveTrue(@Param("key") String key);
}

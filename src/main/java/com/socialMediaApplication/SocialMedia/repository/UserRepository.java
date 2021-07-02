package com.socialMediaApplication.SocialMedia.repository;

import com.socialMediaApplication.SocialMedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByPhoneAndIsActiveTrue(String phone);

    User findByIdAndIsActiveTrue(Long id);

    User findByEmailAndIsActiveTrue(String email);

    int countAllByIsActiveTrue();

    int countByUsernameAndIsActiveTrue(String name);

    User findByUsernameAndIsActiveTrue(String userName);

    List<User> findAllByIsActiveTrue();

    @Query(value = "SELECT r.phone FROM User r WHERE r.phone= :phone", nativeQuery = true)
    String findUserByPhone(@Param("phone") String phone);

}

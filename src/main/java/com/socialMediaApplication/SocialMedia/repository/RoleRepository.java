package com.socialMediaApplication.SocialMedia.repository;

import com.socialMediaApplication.SocialMedia.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    int countByNameAndIsActiveTrue(String name);
    Role findByNameAndIsActiveTrue(String name);
}

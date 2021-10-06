package com.meFit.meFit.repository;

import com.meFit.meFit.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the ProfileModel gets extended with JPA functions
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

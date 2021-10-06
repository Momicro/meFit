package com.meFit.meFit.repository;

import com.meFit.meFit.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the UserModel gets extended with JPA functions
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

package com.meFit.meFit.repository;

import com.meFit.meFit.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the WorkoutModel gets extended with JPA functions
@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}

package com.meFit.meFit.repository;

import com.meFit.meFit.models.GoalWorkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the GoalWorkoutmodel gets extended with JPA functions
@Repository
public interface GoalWorkoutRepository extends JpaRepository<GoalWorkout, Long> {
}

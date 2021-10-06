package com.meFit.meFit.repository;

import com.meFit.meFit.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the ExerciseModel gets extended with JPA functions
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Exercise createExercise(Exercise exercise);
    void deleteExercise(Exercise exercise);
}

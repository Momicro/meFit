package com.meFit.meFit.service.impl;

import com.meFit.meFit.models.Exercise;
import com.meFit.meFit.models.Workout;
import com.meFit.meFit.repository.ExerciseRepository;
import com.meFit.meFit.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;

public class ExerciseServiceImpl implements ExerciseService {

    //Get the JPA Services
    @Autowired
    ExerciseRepository exerciseRepository;

    //@Autowired
    //MuscleGroupRepository muscleGroupRepository;

    @Override
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise updateExerciseMuscleGroups(int[] muscleGroupIds, String exerciseId) {

        Exercise exercise = exerciseRepository.getById(Long.parseLong(exerciseId));

        return exerciseRepository.save(exercise);
    }

    //Function to delete the exercise with nested data inside.
    @Override
    public void deleteExercise(Exercise exercise) {

        Workout workout = exercise.getWorkout();
        workout.getExercises().remove(exercise);

        exerciseRepository.delete(exercise);
    }
}

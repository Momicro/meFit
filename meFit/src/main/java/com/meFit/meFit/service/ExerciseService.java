package com.meFit.meFit.service;

import com.meFit.meFit.models.Exercise;

//exercise service interface
public interface ExerciseService {

    Exercise createExercise(Exercise exercise);

    //First concatenate the Array with the List to then add it back to the Exercise and return the updated exercise in the RestController
    Exercise updateExerciseMuscleGroups(int[] muscleGroupIds, String exerciseId);

    //Function to delete the exercises with nested data inside.
    void deleteExercise(Exercise exercise);
}

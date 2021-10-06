package com.meFit.meFit.service;

import com.meFit.meFit.models.Workout;

//Workout service interface
public interface WorkoutService {

    //Function to create a new workout with nested data inside.
    Workout createWorkout(Workout workout);

    //Function to delete the workout with nested data inside.
    void deleteWorkout(Workout workout);
}

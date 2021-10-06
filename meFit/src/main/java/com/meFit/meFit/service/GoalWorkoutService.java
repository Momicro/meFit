package com.meFit.meFit.service;

import com.meFit.meFit.models.GoalWorkout;

//GoalWorkout service interface
public interface GoalWorkoutService {

    GoalWorkout createGoalWorkout(GoalWorkout goalWorkout);

    //Function to delete the goalWorkout with nested data inside.
    void deleteGoalWorkout(GoalWorkout goalWorkout);
}

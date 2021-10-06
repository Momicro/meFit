package com.meFit.meFit.service;

import com.meFit.meFit.models.Goal;

//Goal service interface
public interface GoalService {

    Goal createGoal(Goal goal);

    //Function to delete the goal with nested data inside.
    void deleteGoal(Goal goal);
}

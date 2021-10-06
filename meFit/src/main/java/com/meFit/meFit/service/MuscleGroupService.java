package com.meFit.meFit.service;

import com.meFit.meFit.models.MuscleGroup;

//MuscleGroup service interface
public interface MuscleGroupService {

    //Function to create the MuscleGroup with nested data inside.
    MuscleGroup createMuscleGroup(MuscleGroup muscleGroup);

    //Function to delete the MuscleGroup with nested data inside.
    void deleteMuscleGroup(MuscleGroup muscleGroup);
}

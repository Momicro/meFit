package com.meFit.meFit.service;

import com.meFit.meFit.models.Goal;
import com.meFit.meFit.models.Profile;

public interface ProfileService {
    //Function to create the profile with nested data inside.
    Goal createProfile(Profile profile);

    //Function to delete the profile with nested data inside.
    void deleteProfile(Profile profile);
}

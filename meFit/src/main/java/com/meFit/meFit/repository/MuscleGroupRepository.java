package com.meFit.meFit.repository;

import com.meFit.meFit.models.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the MuscleGroupModel gets extended with JPA functions
@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
}

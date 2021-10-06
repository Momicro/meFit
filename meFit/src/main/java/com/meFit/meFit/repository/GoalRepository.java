package com.meFit.meFit.repository;

import com.meFit.meFit.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//In this repository the goal model gets extended with JPA functions
@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

    Goal createGoal(Goal goal);
}

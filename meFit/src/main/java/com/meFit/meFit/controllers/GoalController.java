package com.meFit.meFit.controllers;

import com.meFit.meFit.models.Goal;
import com.meFit.meFit.repository.GoalRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiOperation(value = "/api/v1/goals", tags = "Goals Controller")
@RequestMapping("/api/v1/goals")
public class GoalController {

    @Autowired
    GoalRepository goalRepository;

    //get all goals
    @ApiOperation(value = "Get all goals", response = List.class)
    @GetMapping
    public List<Goal> getAllGoals(){
        return this.goalRepository.findAll();
    }

    //get goal by id
    @ApiOperation(value = "Get a specific goal", response = Goal.class)
    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable(value="id") long goalId)
            throws ResourceNotFoundException {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found for this id " + goalId));
        return ResponseEntity.ok().body(goal);
    }

    //save exercise
    @ApiOperation(value = "Create a goal", response = Goal.class)
    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        return new ResponseEntity<Goal>(goalRepository.createGoal(goal), HttpStatus.CREATED);
    }



}

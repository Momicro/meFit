package com.meFit.meFit.controllers;

import com.meFit.meFit.models.Exercise;
import com.meFit.meFit.repository.ExerciseRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ApiOperation(value = "/api/v1/exercises", tags = "Exercises Controller")
@RequestMapping("/api/v1/exercises")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    //get all exercises
    @ApiOperation(value = "Get all exercises", response = List.class)
    @GetMapping
    public List<Exercise> getAllExercises(){
        return this.exerciseRepository.findAll();
    }

    //get exercise by id
    @ApiOperation(value = "Get a specific exercise", response = Exercise.class)
    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable(value="id") long exerciseId)
            throws ResourceNotFoundException {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("exercise not found for this id " + exerciseId));
        return ResponseEntity.ok().body(exercise);
    }

    //save exercise
    @ApiOperation(value = "Create a exercise", response = Exercise.class)
    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        return new ResponseEntity<Exercise>(exerciseRepository.createExercise(exercise), HttpStatus.CREATED);
    }

    //update exercise
    @ApiOperation(value = "Update an exercise", response = Exercise.class)
    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable(value="id") long exerciseId,
                                             @RequestBody Exercise exerciseDetails)
            throws ResourceNotFoundException {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("exercise not found for this id " + exerciseId));

        exercise.setName(exerciseDetails.getName());
        exercise.setDescription(exerciseDetails.getDescription());

        return ResponseEntity.ok(this.exerciseRepository.save(exercise));
    }

    //delete exercise
    @ApiOperation(value = "delete an exercise", response = Exercise.class)
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteExercise(@PathVariable(value = "id") long exerciseId)
            throws ResourceNotFoundException {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new ResourceNotFoundException("Exercise not found for this id " + exerciseId));

        this.exerciseRepository.deleteExercise(exercise);

        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }

    //Delete all exercises
    @ApiOperation(value = "Delete all exercises", response = List.class)
    @DeleteMapping
    public void deleteAllExercises(){
        this.exerciseRepository.deleteAll();
    }

}

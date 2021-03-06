package com.meFit.meFit.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "Workout")
@ApiModel(description = "Workout Model")
public @Data class Workout {

    //autogenerated ID which never has to be defined in future functions.
    @ApiModelProperty(notes = "ID of the workout", name = "id", value = "1" )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Here the static components of the model
    @ApiModelProperty(notes = "name", name = "name", value = "something"  )
    @Column(name="name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    @ApiModelProperty(notes = "type", name = "type", value = "something"  )
    @Column(name="type",
            nullable = false,
            columnDefinition = "TEXT")
    private String type;

    //related data
    //programs - workouts -binding
    @ApiModelProperty(notes = "A List of IDs to programs in the database, the workout acts in.", name = "programlist" )
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name="workout_programs",
            joinColumns = {@JoinColumn(name="workout_id")},
            inverseJoinColumns = {@JoinColumn(name="program_id")}
    )
    private Set<Program> programs = new HashSet<>();

    //to regulate the output only a List of the programIDs will be returned
    @JsonGetter("programs")
    public List<String> programsGetter() {
        if(programs != null){
            return programs.stream()
                    .map(program -> {
                        return "/api/v1/programs/" + program.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }

    //related data
    //workout - exercises - relation
    @ApiModelProperty(notes = "List of exercises in the workout", name = "exerciselist")
    @OneToMany(cascade = {/*CascadeType.ALL, */CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, mappedBy="workout")
    public Set<Exercise> exercises = new HashSet<>();

    // restricts the output to a List of IDs of the exercises
    @JsonGetter("exercises")
    public List<String> exercises() {
        if(exercises != null) {
            return exercises.stream()
                    .map(exercise -> {
                        return "/api/v1/exercises/" + exercise.getId();
                    }).collect(Collectors.toList());
        }
        return null;
    }
}

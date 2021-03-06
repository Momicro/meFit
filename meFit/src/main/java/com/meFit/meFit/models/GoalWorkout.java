package com.meFit.meFit.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GoalWorkout")
@ApiModel(description = "GoalWorkout Model")
public @Data class GoalWorkout {

    //autogenerated ID which never has to be defined in future functions.
    @ApiModelProperty(notes = "ID of the user goal workout", name = "id", value = "1" )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //autogenerated ID which never has to be defined in future functions.
    @ApiModelProperty(notes = "completed", name = "completed", value = "no"  )
    @Column(name="completed",
            nullable = false,
            columnDefinition = "TEXT")
    private boolean completed;
}

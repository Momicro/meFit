package com.meFit.meFit.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "UserRight")
@ApiModel(description = "UserRight Model")
public @Data class UserRight {

    //autogenerated ID which never has to be defined in future functions.
    @ApiModelProperty(notes = "ID of the user right", name = "id", value = "1" )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Here the static components of the model

    @ApiModelProperty(notes = "name", name = "name", value = "something"  )
    @Column(name="name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;

    private enum Roles {USER, CONTRIBUTER, ADMIN};

}

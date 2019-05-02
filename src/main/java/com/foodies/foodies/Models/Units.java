package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class Units implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long unitId;

    @Column(unique = true)
    @NotBlank(message = "Measuring unit is required.")
    private String unit;

    protected Units() {}

    Units(String unit) {
        this.unit = unit;
    }
}

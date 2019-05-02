package com.foodies.foodies.Models;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;

@Data
@Entity
@Table(name = "categories")
public class Categories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Category name is required.")
    private String categoryName;

    protected Categories() {}

    Categories(String categoryName) {
        this.categoryName = categoryName;
    }
}

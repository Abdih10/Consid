package com.example.consid.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO that contains information required to create a new category
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryCreationDto {
    private String name;
}

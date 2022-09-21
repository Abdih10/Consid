package com.example.consid.models.dto;

import com.example.consid.models.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DTO that contains information required to create a new category
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CategoryDto {
    private Integer id;
    private String name;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getCategoryName();
    }

}

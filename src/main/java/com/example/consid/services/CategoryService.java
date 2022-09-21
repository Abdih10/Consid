package com.example.consid.services;

import com.example.consid.models.dto.creation.CategoryCreationDto;
import com.example.consid.models.dto.response.CategoryDto;
import com.example.consid.models.entities.Category;
import com.example.consid.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Converts Entity to Dto
     *
     * @param category the category to convert
     * @return CategoryDto
     */
    private static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getCategoryName())
                .build();
    }

    /**
     * Find all categories
     *
     * @return list of all categories
     */
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryService::toDto).collect(Collectors.toList());
    }

    /**
     * @param id category id
     * @return category, if the id existed in database
     * @throws RuntimeException if the provided id can't be found
     */
    public CategoryDto findCategoryById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
        return toDto(category);
    }

    /**
     * Creates a new category
     *
     * @param
     * @return categoryDto
     */
    public CategoryDto createCategory(CategoryCreationDto createDto) {
        Category category = new Category();
        category.setCategoryName(createDto.getName());
        categoryRepository.save(category);
        return new CategoryDto(category);
    }

    /**
     * Updates given category with the fields in dto
     *
     * @param categoryId id of category which should be updated
     * @return Dto
     */
    public CategoryDto editCategory(Integer categoryId, CategoryCreationDto createDto) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(RuntimeException::new);
        category.setCategoryName(createDto.getName());
        categoryRepository.save(category);
        return new CategoryDto(category);
    }

    /**
     * Delete a category
     *
     * @param id id of category to delete
     * @throws RuntimeException if provided id doesn't exist
     */
    public void deleteCategoryById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(RuntimeException::new);
        categoryRepository.delete(category);
    }
}

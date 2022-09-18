package com.example.consid.services;

import com.example.consid.models.Category;
import com.example.consid.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findbyId(String id) {
        return categoryRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Category addCategory(@RequestBody Category newCategory) {
        return categoryRepository.save(newCategory);
    }
}

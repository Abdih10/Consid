package com.example.consid.rest;

import com.example.consid.models.Category;
import com.example.consid.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/category")
@RequestMapping
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public Iterable<Category> all() {
        return categoryService.findAll();
    }

    @GetMapping
    public Category categoryID(@RequestParam String id) {
        return categoryService.findbyId(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category newCategory) {
        return categoryService.addCategory(newCategory);
    }
}

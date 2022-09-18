package com.example.consid.repositories;

import com.example.consid.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, String> {
    @Override
    List<Category> findAll();
}

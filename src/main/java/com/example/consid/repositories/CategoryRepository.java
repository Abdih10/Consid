package com.example.consid.repositories;

import com.example.consid.models.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Override
    List<Category> findAll();

}

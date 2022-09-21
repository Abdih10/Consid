package com.example.consid.repositories;

import com.example.consid.models.entities.LibraryItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryItemRepository extends CrudRepository<LibraryItem, String> {
    @Override
    List<LibraryItem> findAll();
}

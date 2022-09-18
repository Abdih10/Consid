package com.example.consid.services;

import com.example.consid.models.LibraryItem;
import com.example.consid.repositories.LibraryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LibraryItemService {
    private final LibraryItemRepository libraryItemRepository;

    @Autowired
    public LibraryItemService(LibraryItemRepository libraryItemRepository) {
        this.libraryItemRepository = libraryItemRepository;
    }

    public List<LibraryItem> findAll() {
        return (List<LibraryItem>) libraryItemRepository.findAll();
    }

    public LibraryItem findbyId(String id) {
        return libraryItemRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public LibraryItem addItem(@RequestBody LibraryItem newItem) {
        return libraryItemRepository.save(newItem);
    }
}

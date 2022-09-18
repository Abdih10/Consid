package com.example.consid.rest;

import com.example.consid.models.LibraryItem;
import com.example.consid.services.LibraryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libraryitem")
public class LibraryItemController {
    private final LibraryItemService libraryItemService;

    @Autowired
    public LibraryItemController(LibraryItemService libraryItemService) {
        this.libraryItemService = libraryItemService;
    }

    @GetMapping("/all")
    public Iterable<LibraryItem> all() {
        return libraryItemService.findAll();
    }

    @GetMapping
    public LibraryItem libraryItem(@RequestParam String id) {
        return libraryItemService.findbyId(id);
    }

    @PostMapping
    public LibraryItem newItem(@RequestBody LibraryItem newitem) {
        return libraryItemService.addItem(newitem);
    }
}

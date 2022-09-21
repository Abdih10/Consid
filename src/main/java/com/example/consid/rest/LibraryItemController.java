package com.example.consid.rest;

import com.example.consid.models.entities.LibraryItem;
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

    /**
     * Create library items of the types book, reference book, dvd and audio book.
     */
    /**
     * Edit and delete library items.
     */

    /**
     * Check in/Check out library items that is borrowable (book, dvd and audiobook)
     */

    /**
     *  Listing library items should be sorted by Category Name. This can be changed to
     *     Type by the user. (This change need to persist in current session but not after
     *     application restart)
     *             Acronym after the title of library items (e.g. “The title (TT)”)
     *             Validation on input fields.
     */
}

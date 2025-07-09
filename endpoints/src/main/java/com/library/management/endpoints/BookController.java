package com.library.management.endpoints;

import com.library.management.domain.Book;
import com.library.management.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public Book addBooks(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}

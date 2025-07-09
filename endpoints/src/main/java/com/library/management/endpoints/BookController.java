package com.library.management.endpoints;

import com.library.management.domain.Book;
import com.library.management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook (@Valid @RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/update/{ISBN}")
    public ResponseEntity<Book> updateBook(@PathVariable String ISBN, @Valid @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(ISBN, book);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/{ISBN}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String ISBN) {
        Book book = bookService.getBookByIsbn(ISBN);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/delete/{ISBN}")
    public ResponseEntity<Book> deleteBook(@PathVariable String ISBN) {
        Book deletedBook = bookService.deleteBook(ISBN);
        return ResponseEntity.ok(deletedBook);
    }
}

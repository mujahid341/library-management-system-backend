package com.library.management.service;
import com.library.management.domain.Book;

public interface BookService {
    Book addBook(Book book);
    Book getBookByIsbn(String ISBN);
    Book updateBook(String iSBN, Book book);
    Book deleteBook(String ISBN);
    Iterable<Book> getAllBooks();
}

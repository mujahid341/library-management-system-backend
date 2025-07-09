package com.library.management.service;
import com.library.management.domain.Book;

public interface BookService {
    public Book addBook(Book book);
    public Book getBookById(Long id);
}

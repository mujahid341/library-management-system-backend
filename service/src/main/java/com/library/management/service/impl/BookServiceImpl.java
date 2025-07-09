package com.library.management.service.impl;

import com.library.management.domain.Book;
import com.library.management.repository.BookRepository;
import com.library.management.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public Book addBook(Book book) {
        try {

            Optional<Book> existingBookOpt = bookRepository.findByIsbn(book.getIsbn());
            if (existingBookOpt.isPresent()) {
                Book existingBook = existingBookOpt.get();
                existingBook.setTotalCopies(existingBook.getTotalCopies()+1);
                existingBook.setAvailableCopies(existingBook.getAvailableCopies()+1);
                logger.info("Book already exists: {}", existingBook);
                return bookRepository.save(existingBook);
            }

            logger.info("book is added successfully: {}", book);
            return bookRepository.save(book);
        } catch (Exception e) {
            logger.error("Error adding book: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Book getBookByIsbn(String ISBN) {
        return bookRepository.findByIsbn(ISBN)
                .orElseThrow(() -> new RuntimeException("Book not found with ISBN: " + ISBN));
    }

    @Override
    public Book updateBook(String ISBN, Book book) {
        Optional<Book> existingBookOpt = bookRepository.findByIsbn(ISBN);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setTotalCopies(book.getTotalCopies());
            existingBook.setAvailableCopies(book.getAvailableCopies());
            logger.info("Book updated successfully: {}", existingBook);
            return bookRepository.save(existingBook);
        } else {
            logger.error("Book not found with ISBN: {}", ISBN);
            throw new RuntimeException("Book not found with ISBN: " + ISBN);
        }
    }

    @Override
    public Book deleteBook(String ISBN) {
        Optional<Book> existingBookOpt = bookRepository.findByIsbn(ISBN);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            bookRepository.delete(existingBook);
            logger.info("Book deleted successfully: {}", existingBook);
            return existingBook;
        } else {
            logger.error("Book not found with ISBN: {}", ISBN);
            throw new RuntimeException("Book not found with ISBN: " + ISBN);
        }
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

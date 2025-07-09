package com.library.management.service.impl;

import com.library.management.domain.Book;
import com.library.management.repository.BookRepository;
import com.library.management.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public Book addBook(Book book) {
        try {
            logger.info("Adding book: {}", book);
            return bookRepository.save(book);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Book getBookById(Long id) {
        return null;
    }
}

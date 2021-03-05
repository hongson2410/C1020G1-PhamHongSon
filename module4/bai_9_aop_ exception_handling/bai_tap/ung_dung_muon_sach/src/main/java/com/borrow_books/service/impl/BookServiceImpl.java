package com.borrow_books.service.impl;

import com.borrow_books.model.Book;
import com.borrow_books.repository.BookRepository;
import com.borrow_books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> findAllBook() {
        return repository.findAll();
    }

    @Override
    public Book findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public Book findByCode(String code) {
        return repository.findByCode(code);
    }
}

package com.borrow_books.service;

import com.borrow_books.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    Book findById(int id);
    void save(Book book);
    Book findByCode(String code);
}

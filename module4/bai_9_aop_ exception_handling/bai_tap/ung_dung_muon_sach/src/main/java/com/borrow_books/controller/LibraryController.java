package com.borrow_books.controller;

import com.borrow_books.service.BookService;
import com.borrow_books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LibraryController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;
}

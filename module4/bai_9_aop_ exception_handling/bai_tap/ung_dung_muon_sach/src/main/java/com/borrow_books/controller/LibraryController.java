package com.borrow_books.controller;

import com.borrow_books.model.Book;
import com.borrow_books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String showLibrary(Model model){
        model.addAttribute("books", bookService.findAllBook());
        return "home";
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, Model model){
        Book book = bookService.findById(id);
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);
        model.addAttribute("books", bookService.findAllBook());
        return "home";
    }

    @GetMapping("/give")
    public String showFormCode(){
        return "give_book";
    }

    @PostMapping("/give")
    public String giveBookBack(@RequestParam(name = "code") String code, Model model){
        Book book= bookService.findByCode(code);
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);
        model.addAttribute("books", bookService.findAllBook());
        return "home";
    }
}

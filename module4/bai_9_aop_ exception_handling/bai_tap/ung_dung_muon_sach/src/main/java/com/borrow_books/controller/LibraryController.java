package com.borrow_books.controller;

import com.borrow_books.concern.Logger;
import com.borrow_books.model.Book;
import com.borrow_books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String borrowBook(@PathVariable Integer id) throws Exception{
        Book book = bookService.findById(id);
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);
        Logger.code= book.getCode();
        return "redirect:/";
    }

    @GetMapping("/give")
    public String showFormCode(){
        return "give_book";
    }

    @PostMapping("/give")
    public String giveBookBack(@RequestParam(name = "code") String code) throws Exception{
        Book book= bookService.findByCode(code);
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);
        Logger.code= code;
        return "redirect:/";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("inputs-not-acceptable");
    }
}

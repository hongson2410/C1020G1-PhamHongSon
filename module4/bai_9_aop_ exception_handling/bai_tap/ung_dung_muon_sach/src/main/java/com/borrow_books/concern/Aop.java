package com.borrow_books.concern;

import com.borrow_books.controller.LibraryController;
import com.borrow_books.model.Book;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class Aop {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryController.class);

    public static Book book;

    private static int count = 1;

    @AfterReturning(pointcut = "execution(public * com.borrow_books.controller.LibraryController.borrowBook(*))")
    public void afterBorrowBook() {
        LOGGER.debug("Sách vừa được mượn mã: " + book.getCode() + "; số lượng còn: " + book.getQuantity());
    }

    @AfterReturning(pointcut = "execution(public * com.borrow_books.controller.LibraryController.giveBookBack(*))")
    public void afterGiveBook() {
        LOGGER.debug("Sách vừa được trả mã: " + book.getCode() + "; số lượng còn: " + book.getQuantity());
    }

    @AfterReturning(pointcut = "execution(public * com.borrow_books.controller.LibraryController.showLibrary(*))")
    public void visitHome() {
        LOGGER.debug("Số người ghé thăm : " + count++);
    }

    @AfterThrowing(pointcut = "execution(public * com.borrow_books.controller.*.*(..))", throwing = "e")
    public void exception(Exception e) {
        LOGGER.debug("Có lỗi xảy ra: " + e.getMessage());
    }
}

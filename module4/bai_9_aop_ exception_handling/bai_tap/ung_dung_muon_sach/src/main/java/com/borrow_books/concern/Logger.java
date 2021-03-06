package com.borrow_books.concern;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.io.*;

@Aspect
public class Logger {

    public static String code;

    private static int count=1;

    @AfterReturning(pointcut = "execution(public * com.borrow_books.controller.LibraryController.borrowBook(*))")
    public void afterBorrowBook() throws IOException {
        FileWriter fileWriter = new FileWriter("F:\\C1020G1_Pham_Hong_Son\\module4\\bai_9_aop_ exception_handling\\bai_tap\\ung_dung_muon_sach\\src\\main\\resources\\static\\history.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Sách vừa được mượn mã: " + code);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    @AfterReturning(pointcut = "execution(public * com.borrow_books.controller.LibraryController.giveBookBack(*))")
    public void afterGiveBook() throws IOException {
        FileWriter fileWriter = new FileWriter("F:\\C1020G1_Pham_Hong_Son\\module4\\bai_9_aop_ exception_handling\\bai_tap\\ung_dung_muon_sach\\src\\main\\resources\\static\\history.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Sách vừa được trả mã: " + code);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    @AfterReturning(pointcut = "execution(public * com.borrow_books.controller.LibraryController.showLibrary(*))")
    public void visitHome() throws IOException {
        FileWriter fileWriter = new FileWriter("F:\\C1020G1_Pham_Hong_Son\\module4\\bai_9_aop_ exception_handling\\bai_tap\\ung_dung_muon_sach\\src\\main\\resources\\static\\history.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Số người ghé thăm : " + (count++));
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}

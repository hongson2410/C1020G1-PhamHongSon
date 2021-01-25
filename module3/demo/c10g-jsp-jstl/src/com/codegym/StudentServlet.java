package com.codegym;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/list"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Duong", "25/01/2021", 1, 4));
        studentList.add(new Student(2, "Van Phuc", "26/01/2021", 0, 6));
        studentList.add(new Student(3, "Luong", "27/01/2021", 0, 9));

        request.setAttribute("studentListFromServlet", studentList);
        request.setAttribute("tmp", "<p style='color: red'>Hello C10</p>");
        request.getRequestDispatcher("list_student.jsp").forward(request, response);
    }
}

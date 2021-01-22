package com.codegym;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", urlPatterns = "/sum2Number")
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberOne = Integer.parseInt(request.getParameter("number1"));
        int numberTwo = Integer.parseInt(request.getParameter("number2"));
        int total = numberOne + numberTwo;

//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("<html>");
//        printWriter.print("<body>");
//        printWriter.print("<h2 style='color: red'>" + total + "</h2>");
//        printWriter.print("</body>");
//        printWriter.print("</html>");

        request.setAttribute("total2Number", total);
//        request.getRequestDispatcher("result.jsp").forward(request, response);
        response.sendRedirect("result.jsp");
    }
}

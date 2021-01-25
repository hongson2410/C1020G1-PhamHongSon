import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"", "/list"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Kiên", "12/12/2012", "Nghệ An", "image/9eb6abaa" +
                "-8cda-456c-ad66-26ba4da23ffe.jpg"));
        customerList.add(new Customer("Cao", "11/11/2011", "Huế", "https://dogily.vn/wp-" +
                "content/uploads/2019/08/Hon-ca-the-gioi-anh-cho-Anuko.jpg"));
        customerList.add(new Customer("Dũng", "09/09/2009", "Nghệ An", "https://bizweb." +
                "dktcdn.net/thumb/large/100/036/299/products/product2908.jpg"));

        request.setAttribute("customerListFromServlet", customerList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Cristiano Ronaldo","1985-02-05","Portugal",
                "image/Cristiano_Ronaldo.jpg"));
        customerList.add(new Customer("Lionel Messi","1987-06-24","Argentina",
                "image/Lionel_Messi.jpg"));
        customerList.add(new Customer("Neymar Jr","1992-03-05","Brazil",
                "image/neymar.jpg"));
        customerList.add(new Customer("Kylian Mbappe","1998-12-20","France",
                "image/kylian-mbappe.jpg"));

        request.setAttribute("customerListServlet",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}

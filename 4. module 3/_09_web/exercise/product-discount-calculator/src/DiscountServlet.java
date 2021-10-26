import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDescription = request.getParameter("productDescription");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));

        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);
        request.setAttribute("productDescription", productDescription);
        request.setAttribute("listPrice", listPrice);
        request.setAttribute("discountPercent", discountPercent);
        request.getRequestDispatcher("display-discount.jsp").forward(request, response);


    }
}

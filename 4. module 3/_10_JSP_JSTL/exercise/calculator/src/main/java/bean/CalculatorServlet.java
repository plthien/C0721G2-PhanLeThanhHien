package bean;

import bean.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bean.CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double a = Double.parseDouble(request.getParameter("firstOperand"));
            double b = Double.parseDouble(request.getParameter("secondOperand"));
            String flag = request.getParameter("operator");
            String operator;
            switch (flag) {
                case "addition":
                    operator = "+";
                    break;
                case "subtraction":
                    operator = "-";
                    break;
                case "multiplication":
                    operator = "*";
                    break;
                default:
                    operator = "/";
            }
            double result = Calculator.calculate(a, b, flag);
            request.setAttribute("resultFromServlet", result);
            request.setAttribute("aFromServlet", a);
            request.setAttribute("bFromServlet", b);
            request.setAttribute("operatorFromServlet", operator);
            request.setAttribute("equalFromServlet", "=");
            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("exceptionFromServlet", "It's not a number!");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (ArithmeticException e) {
            request.setAttribute("exceptionFromServlet", e.getMessage());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }


    }
}

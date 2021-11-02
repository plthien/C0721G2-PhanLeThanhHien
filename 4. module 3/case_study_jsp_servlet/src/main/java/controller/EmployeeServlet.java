package controller;

import bean.Employee;
import service.EmployeeService;
import service.Impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuramaServlet", urlPatterns = {"/employees"})
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null) {
            userAction = "";
        }
        switch (userAction){
            case "create":
                createEmployee(request,response);
                break;
//            case "edit":
//                updateUser(request,response);
//                break;
//            case "delete":
//                deleteUser(request,response);
//                break;
//            case "search":
//                searchUser(request,response);
//                break;
            default:
                break;


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null) {
            userAction = "";
        }
        switch (userAction) {
            case "create":
                showCreateEmployeeForm(request,response);
                break;
//            case "edit":
//                showEditForm(request,response);
//                break;
//            case "sort":
//                sortUser(request,response);
//                break;
            default:
                employeeList(request, response);
                break;

        }
    }

    public void employeeList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = this.employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("pages/employee-list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("pages/create-employee.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("input-name");
        String birthday = request.getParameter("input-birthday");
        String gender = request.getParameter("input-gender");
        String personalID = request.getParameter("input-personal-id");
        String phoneNumber = request.getParameter("input-phone-number");
        String address = request.getParameter("input-address");
        String degree = request.getParameter("input-degree");
        String office = request.getParameter("input-office");
        String department = request.getParameter("input-department");
        Double salary = Double.parseDouble(request.getParameter("input-salary")) ;
        String email = request.getParameter("input-email");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setBirthday(birthday);
        employee.setGender(gender);
        employee.setPersonalID(personalID);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setDegree(degree);
        employee.setOffice(office);
        employee.setDepartment(department);
        employee.setSalary(salary);
        employee.setEmail(email);

        this.employeeService.save(employee);
        try {
            response.sendRedirect("/employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

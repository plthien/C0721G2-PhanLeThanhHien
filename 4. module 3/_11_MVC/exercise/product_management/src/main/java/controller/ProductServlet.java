package controller;

import bean.Product;
import service.IProductService;
import service.Impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/products"})
public class ProductServlet extends HttpServlet {
    private IProductService iProductService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProduct(request, response);
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = this.iProductService.findAll();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("view/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        double price = Double.parseDouble(request.getParameter("price"));
        int id = (int)(Math.random() * 10000);

        Product product = new Product(id,name,price,description,brand);
        this.iProductService.save(product);
        request.setAttribute("message","New product was create!");
        try {
            request.getRequestDispatcher("view/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findById(id);
        if (product == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else{
            request.setAttribute("product",product);
            try {
                request.getRequestDispatcher("view/edit.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        double price = Double.parseDouble(request.getParameter("price"));
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findById(id);
        product.setName(name);
        product.setBrand(brand);
        product.setDescription(description);
        product.setPrice(price);
        this.iProductService.update(id,product);
        request.setAttribute("product",product);
        request.setAttribute("message","Product information was updated!");
        try {
            request.getRequestDispatcher("view/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response){
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findById(id);
        if (product == null){
            request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product",product);
        }
        try {
            request.getRequestDispatcher("view/delete.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response){
        int id =Integer.parseInt(request.getParameter("id"));
        this.iProductService.remove(id);
        request.setAttribute("message","Product was deleted!");
        try {
            request.getRequestDispatcher("view/delete.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response){
        int id =Integer.parseInt(request.getParameter("id"));
        Product product = this.iProductService.findById(id);
        if (product == null) {
            request.getRequestDispatcher("error-404.jsp");
        } else{
            request.setAttribute("product",product);
            try {
                request.getRequestDispatcher("view/view.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

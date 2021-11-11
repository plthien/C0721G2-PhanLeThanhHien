package controller;

import bean.Book;
import bean.Card;
import bean.Student;
import service.Impl.CardService;
import service.Impl.CardServiceImpl;
import utils.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CardServlet", urlPatterns = {"","/cards"})
public class CardServlet extends HttpServlet {
    private CardService cardService = new CardServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAction = request.getParameter("userAction");
        if (userAction == null) {
            userAction = "";
        }
        switch (userAction) {
            case "rent":
                rentBook(request,response);
                break;
//            case "edit":
//                updateContract(request,response);
//                break;
//            case "search":
//                searchContract(request,response);
//                break;
//            case "createDetail":
//                createContractDetail(request,response);
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
            case "rent":
                showFormRentBook(request, response);
                break;
////                case "edit":
////                    showEditContractForm(request, response);
//////                    break;
//            case "delete":
//                xoaMatBang(request, response);
//                break;
//                case "contractDetail":
//                    contractDetailList(request, response);
//                    break;
//                case "createDetail":
//                    showCreateContractDetailForm(request, response);
//                    break;
//                case "deleteContractDetail":
//                    deleteContractDetail(request, response);
//                    break;
            default:
                bookList(request, response);
                break;

        }
    }
    public void bookList(HttpServletRequest request, HttpServletResponse response){
        List<Book> bookList = cardService.findAllBook();
        request.setAttribute("bookList",bookList);
        try {
            request.getRequestDispatcher("/pages/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showFormRentBook(HttpServletRequest request, HttpServletResponse response){
        String idBook = request.getParameter("id");
        List<Book> bookList = cardService.findBookById(idBook);
        List<Student> studentList = cardService.findAllStudent();
        request.setAttribute("studentList",studentList);
        request.setAttribute("bookList",bookList);
        try {
            request.getRequestDispatcher("/pages/create.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void rentBook(HttpServletRequest request, HttpServletResponse response){
        String idBook = request.getParameter("idBook");
        String idCard = request.getParameter("idCard");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String idMess = null;
        boolean flag = true;
        if (!Validate.checkIDCard(idCard)){
            idMess = "Id is invalid";
            flag = false;
        }
        String idStudent = request.getParameter("idStudent");

        String rentDate = request.getParameter("rentDate");
        String payDate = request.getParameter("payDate");
        String dateMess = null;
        if (!Validate.checkDate(rentDate,payDate)){
            dateMess = "Date is invalid!";
            flag = false;
        }

        Student student = new Student();
        student.setId(idStudent);

        Book book = new Book();
        book.setId(idBook);
        book.setQuantity(quantity);

        Card card = new Card();
        card.setId(idCard);
        card.setBook(book);
        card.setStudent(student);
        card.setRentDate(rentDate);
        card.setPayDate(payDate);

        if (!flag){
            request.setAttribute("idMess",idMess);
            request.setAttribute("dateMess",dateMess);
            request.setAttribute("card",card);
            showFormRentBook(request,response);
        }else {
            cardService.rentBook(card);
            List<Card> cardList = cardService.findAllCard();
            request.setAttribute("cardList",cardList);
            try {
                request.getRequestDispatcher("/pages/listCard.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}

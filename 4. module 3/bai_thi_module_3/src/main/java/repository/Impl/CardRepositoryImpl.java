package repository.Impl;

import bean.Book;
import bean.Card;
import bean.Student;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements  CardRepository{
    @Override
    public List<Book> findAllBook() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from book ");
            ResultSet resultSet = preparedStatement.executeQuery();

            Book book = null;
            while (resultSet.next()){
                book = new Book();
                book.setId(resultSet.getString("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setName(resultSet.getString("name"));
                book.setDescription(resultSet.getString("description"));
                book.setQuantity(resultSet.getInt("quantity"));

                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> findBookById(String id) {
        List<Book> bookList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = BaseRepository.connection.prepareStatement("select * from book where id=?");
            preparedStatement.setString(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            Book book = null;
            while (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getString("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setName(resultSet.getString("name"));
                book.setDescription(resultSet.getString("description"));
                book.setQuantity(resultSet.getInt("quantity"));

                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select  * from student ");
            ResultSet resultSet = preparedStatement.executeQuery();

            Student student = null;
            while (resultSet.next()){
                student = new Student();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setClassStudent("class_student");

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void rentBook(Card card) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("insert  into card(id,id_book,id_student,rent_date,pay_date) " +
                            " values (?,?,?,?,?)");
            preparedStatement.setString(1,card.getId());
            preparedStatement.setString(2,card.getBook().getId());
            preparedStatement.setString(3,card.getStudent().getId());
            preparedStatement.setString(4,card.getRentDate());
            preparedStatement.setString(5,card.getPayDate());
            preparedStatement.executeUpdate();
            int quantity = card.getBook().getQuantity() - 1;
            PreparedStatement preparedStatement1 = BaseRepository.connection.prepareStatement("update book set quantity =? where id =?");
            preparedStatement1.setInt(1,quantity);
            preparedStatement1.setString(2,card.getBook().getId());
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Card> findAllCard() {
        List<Card> cardList = new ArrayList<>();
        try {
            CallableStatement callableStatement = BaseRepository.connection.prepareCall("{call get_all_card()}");
            ResultSet resultSet = callableStatement.executeQuery();
            Card card = null;
            Book book = null;
            Student student = null;
            while (resultSet.next()){
                card = new Card();
                book = new Book();
                student = new Student();

                card.setId(resultSet.getString("id"));
                card.setStatus(resultSet.getBoolean("status"));
                card.setRentDate(resultSet.getString("rent_date"));
                card.setPayDate(resultSet.getString("pay_date"));
                book.setName(resultSet.getString("book_name"));
                student.setName(resultSet.getString("student_name"));
                student.setClassStudent(resultSet.getString("class_student"));
                card.setBook(book);
                card.setStudent(student);

                cardList.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cardList;
    }
}

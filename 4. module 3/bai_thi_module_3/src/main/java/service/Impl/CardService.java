package service.Impl;

import bean.Book;
import bean.Card;
import bean.Student;

import java.util.List;

public interface CardService {
    List<Book> findAllBook();
    List<Book> findBookById(String id);
    List<Student> findAllStudent();
    void rentBook(Card card);
    List<Card> findAllCard();
}

package service.Impl;

import bean.Book;
import bean.Card;
import bean.Student;
import repository.Impl.CardRepository;
import repository.Impl.CardRepositoryImpl;

import java.util.List;

public class CardServiceImpl implements CardService {
    private CardRepository cardRepository = new CardRepositoryImpl();
    @Override
    public List<Book> findAllBook() {
        return cardRepository.findAllBook();
    }

    @Override
    public List<Book> findBookById(String id) {
        return cardRepository.findBookById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return cardRepository.findAllStudent();
    }

    @Override
    public void rentBook(Card card) {
        cardRepository.rentBook(card);
    }

    @Override
    public List<Card> findAllCard() {
        return cardRepository.findAllCard();
    }
}

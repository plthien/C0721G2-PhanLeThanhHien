package com.codegym.bookmanagement.service;

import com.codegym.bookmanagement.exception.NotFoundBorrowingException;
import com.codegym.bookmanagement.model.BorrowingCard;
import org.springframework.data.domain.Page;

public interface IBorrowingCardService {
    BorrowingCard save(BorrowingCard borrowingCard);


    Page<BorrowingCard> findAll(int page, int size, String sortField, String sortDirection, int status);

    BorrowingCard findOne(String id) throws NotFoundBorrowingException;

    void returnBook(String id);
}

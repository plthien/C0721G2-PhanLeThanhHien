package com.codegym.bookmanagement.service;

import com.codegym.bookmanagement.model.Book;
import org.springframework.data.domain.Page;

public interface IBookService {

    Page<Book> findAllBook(int page, int size, String sortField, String sortDirection);

    Page<Book> findBookByKeyword(int page, int size, String sortField, String sortDirection, String keyword);

    Book findBookById(Long id);

    void decreaseQuantity(Long id, int quantity);

    void increaseQuantity(Long idBook);
}

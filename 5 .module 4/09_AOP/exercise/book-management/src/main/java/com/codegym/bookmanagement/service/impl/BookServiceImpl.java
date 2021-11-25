package com.codegym.bookmanagement.service.impl;

import com.codegym.bookmanagement.model.Book;
import com.codegym.bookmanagement.repository.IBookRepository;
import com.codegym.bookmanagement.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAllBook(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);

        return iBookRepository.findAll(pageable);

    }

    @Override
    public Page<Book> findBookByKeyword(int page, int size, String sortField, String sortDirection, String keyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);

        return iBookRepository.findBookByKeyword(pageable,keyword);
    }

    @Override
    public Book findBookById(Long id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void decreaseQuantity(Long id, int quantity) {
        iBookRepository.decreaseQuantity(id, quantity);
    }

    @Override
    public void increaseQuantity(Long idBook) {
        iBookRepository.increaseQuantity(idBook);
    }


}

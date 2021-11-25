package com.codegym.bookmanagement.service.impl;

import com.codegym.bookmanagement.exception.NotFoundBorrowingException;
import com.codegym.bookmanagement.model.BorrowingCard;
import com.codegym.bookmanagement.repository.IBorrowingCardRepository;
import com.codegym.bookmanagement.service.IBorrowingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowingCardService implements IBorrowingCardService {
    @Autowired
    private IBorrowingCardRepository iBorrowingCardRepository;

    @Override
    public BorrowingCard save(BorrowingCard borrowingCard) {
        return iBorrowingCardRepository.save(borrowingCard);

    }

    @Override
    public Page<BorrowingCard> findAll(int page, int size, String sortField, String sortDirection, int status) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);

        return iBorrowingCardRepository.findAllByStatusIs(pageable, status);
    }

    @Override
    public BorrowingCard findOne(String id) throws NotFoundBorrowingException {
        Optional<BorrowingCard> borrowingCard = iBorrowingCardRepository.findById(id);
        if (borrowingCard.isPresent()){
            return borrowingCard.get();
        } else {
            throw new NotFoundBorrowingException();
        }
    }

    @Override
    public void returnBook(String id) {
        iBorrowingCardRepository.setStatus(id);
    }


}

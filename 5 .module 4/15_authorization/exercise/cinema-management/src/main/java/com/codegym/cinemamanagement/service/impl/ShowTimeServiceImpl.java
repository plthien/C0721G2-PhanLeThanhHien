package com.codegym.cinemamanagement.service.impl;

import com.codegym.cinemamanagement.model.ShowTime;
import com.codegym.cinemamanagement.repository.IShowTimeRepository;
import com.codegym.cinemamanagement.service.IShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShowTimeServiceImpl implements IShowTimeService {
    @Autowired
    private IShowTimeRepository showTimeRepository;

    @Override
    public Page<ShowTime> findAllShowTime(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page,size,sort);

        return showTimeRepository.findAllByStatusIs(1,pageable);
    }

    @Override
    public Page<ShowTime> findShowTimeByMovie(int page, int size, String sortField, String sortDirection, String s) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(page,size,sort);

        return showTimeRepository.findAllByMovie_NameContainingAndStatusIs(s,1,pageable);
    }

    @Override
    public void saveShowTime(ShowTime showTime) {
        showTimeRepository.save(showTime);
    }

    @Override
    public void deleteShowTime(String id) {
        showTimeRepository.removeShowTime(id);
    }
}

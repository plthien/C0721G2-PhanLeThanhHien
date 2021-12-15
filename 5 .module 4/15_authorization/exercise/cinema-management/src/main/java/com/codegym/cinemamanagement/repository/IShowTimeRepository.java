package com.codegym.cinemamanagement.repository;

import com.codegym.cinemamanagement.model.ShowTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IShowTimeRepository extends JpaRepository<ShowTime,Long> {

    Page<ShowTime> findAllByStatusIs(Integer status, Pageable pageable);

    Page<ShowTime> findAllByMovie_NameContainingAndStatusIs(String name, Integer status, Pageable pageable);

    @Modifying
    @Query(value="update show_time set `status` = 0 where id=:id",nativeQuery=true)
    void removeShowTime(@Param("id") String id);
}

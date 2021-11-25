package com.codegym.bookmanagement.repository;

import com.codegym.bookmanagement.model.BorrowingCard;
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
public interface IBorrowingCardRepository extends JpaRepository<BorrowingCard, String> {
//    @Query(value="select * from ",nativeQuery=true)
    Page<BorrowingCard> findAllByStatusIs(Pageable pageable, int status);


    @Modifying
    @Query(value="update borrowing_card b set b.status = 1 where id=:id",nativeQuery=true)
    void setStatus(@Param("id") String id);
}

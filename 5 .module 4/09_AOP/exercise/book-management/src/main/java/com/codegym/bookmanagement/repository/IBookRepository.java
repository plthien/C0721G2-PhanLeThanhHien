package com.codegym.bookmanagement.repository;

import com.codegym.bookmanagement.model.Book;
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
public interface IBookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from books where match(`name`, author, description) against (:keyword)", nativeQuery = true)
    Page<Book> findBookByKeyword(Pageable pageable, @Param("keyword") String keyword);

    @Modifying
    @Query(value = "update books b set b.quantity =?2 where b.id =?1 ", nativeQuery = true)
    void decreaseQuantity(@Param("id") Long id, @Param("quantity") int quantity);


    @Modifying
    @Query(value = "update books b set b.quantity= b.quantity + 1 where b.id=:idBook", nativeQuery = true)
    void increaseQuantity(@Param("idBook") Long idBook);
}

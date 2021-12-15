package com.codegym.demo.repository;

import com.codegym.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IQuestionRepository extends JpaRepository<Question,Long> {

    @Query(value="select * from questions where question_type_id=:questionTypeID order by status ASC, date_create desc ", nativeQuery=true)
    Page<Question> findAllByQuestionTypeId(@Param("questionTypeID") Long questionTypeID, Pageable pageable);

    @Query(value="select * from questions where match(title) against(:keyword) order by status ASC, date_create desc", nativeQuery=true)
    Page<Question> findQuestionByKeyword( @Param("keyword") String keyword,Pageable pageable);

    @Query(value="select * from questions order by status ASC, date_create desc ", nativeQuery=true)
    Page<Question> findAll(Pageable pageable);
}

package com.codegym.demo.service;

import com.codegym.demo.model.Question;
import org.springframework.data.domain.Page;

public interface IQuestionService {
    Page<Question> findQuestionByQuestionType(int page, int size, Long QuestionTypeID);

    Page<Question> findAllQuestion(int page, int size);

    Page<Question> findQuestionByKeyword(int page, int size, String keyword);

    void saveQuestion(Question question);

    void deleteQuestion(Long id);

    Question findById(Long id);
}

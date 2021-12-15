package com.codegym.demo.service.impl;

import com.codegym.demo.model.Question;
import com.codegym.demo.repository.IQuestionRepository;
import com.codegym.demo.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public Page<Question> findQuestionByQuestionType(int page, int size, Long questionTypeID) {
        Pageable pageable = PageRequest.of(page,size);
        return questionRepository.findAllByQuestionTypeId(questionTypeID, pageable);
    }

    @Override
    public Page<Question> findAllQuestion(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> findQuestionByKeyword(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page,size);
        return questionRepository.findQuestionByKeyword(keyword,pageable);
    }

    @Override
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }
}

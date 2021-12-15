package com.codegym.demo.controller;

import com.codegym.demo.model.Question;
import com.codegym.demo.model.QuestionType;
import com.codegym.demo.service.IQuestionService;
import com.codegym.demo.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private IQuestionTypeService questionTypeService;

    @Autowired
    private IQuestionService questionService;

    @ModelAttribute("questionType")
    public List<QuestionType> questionTypes() {
        return questionTypeService.findAll();
    }

    @GetMapping()
    public String viewPageQuestion(@RequestParam(name = "page", defaultValue = "0") int page,
                                   Optional<String> keyword,
                                   Optional<Long> questionTypeID,
                                   Model model
    ) {
        int size = 5;
        Page<Question> questionPage;
        if (!keyword.isPresent() || keyword.get().equals("")) {
            if (questionTypeID.isPresent() && questionTypeID.get() != 0) {
                questionPage = questionService.findQuestionByQuestionType(page, size, questionTypeID.get());
                model.addAttribute("questionTypeID", questionTypeID.get());
            } else {
                questionPage = questionService.findAllQuestion(page, size);
            }
        } else {
            questionPage = questionService.findQuestionByKeyword(page, size, keyword.get());
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("questions", questionPage);

        return "question/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("question/create", "question", new Question());
    }

    @PostMapping("/create")
    public String saveQuestion(@Valid @ModelAttribute("question") Question question,
                               BindingResult bindingResult,
                               Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            System.out.println(bindingResult.toString());
            return "question/create";
        }
        question.setStatus(0);
        LocalDate dateCreate = LocalDate.now();
        question.setDateCreate(dateCreate);
        questionService.saveQuestion(question);
        model.addAttribute("question", new Question());
        model.addAttribute("message", "Add new Question successfully!");
        return "question/create";
    }

    @GetMapping("/delete{id}")
    public String deleteQuestion(@PathVariable("id") Long id,
                                 RedirectAttributes redirectAttributes) {
        questionService.deleteQuestion(id);
        redirectAttributes.addFlashAttribute("message", "Delete Question successfully!");
        return "redirect:/questions";

    }

    @GetMapping("/detail/{id}")
    public String detailBlog(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", questionService.findById(id));
        return "/question/detail";
    }
}

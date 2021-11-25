package com.codegym.bookmanagement.controller;

import com.codegym.bookmanagement.model.Book;
import com.codegym.bookmanagement.model.BorrowingCard;
import com.codegym.bookmanagement.model.Student;
import com.codegym.bookmanagement.service.IBookService;
import com.codegym.bookmanagement.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;


    @GetMapping()
    public String viewPageBook(@RequestParam(value = "page",defaultValue = "0") int page,
                               @RequestParam(value = "sortField", defaultValue = "name") String sortField,
                               @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
                               Optional<String> keyword,
                               Model model) {
        int size = 5;
        Page<Book> books;
        if (!keyword.isPresent() || keyword.get().equals("")) {
            books = iBookService.findAllBook(page, size, sortField, sortDirection);
        } else {
            books = iBookService.findBookByKeyword(page, size, sortField, sortDirection, keyword.get());
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("books", books);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
        return "book/list";
    }



}

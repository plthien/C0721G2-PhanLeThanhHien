package com.codegym.bookmanagement.controller;

import com.codegym.bookmanagement.exception.NotFoundBorrowingException;
import com.codegym.bookmanagement.model.Book;
import com.codegym.bookmanagement.model.BorrowingCard;
import com.codegym.bookmanagement.model.Student;
import com.codegym.bookmanagement.service.IBookService;
import com.codegym.bookmanagement.service.IBorrowingCardService;
import com.codegym.bookmanagement.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/borrowing")
public class BorrowingCardController {

    @Autowired
    private IBorrowingCardService iBorrowingCardService;

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IStudentService iStudentService;


    @ModelAttribute("students")
    public List<Student> students() {
        return iStudentService.findAllStudent();
    }

    @GetMapping()
    public String viewPageBorrowingCard(@RequestParam(value = "page", defaultValue = "0") int page,
                                        @RequestParam(value = "sortField", defaultValue = "dateOfBorrow") String sortField,
                                        @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
                                        Model model) {
        int size = 5;
        Page<BorrowingCard> borrowingCards = iBorrowingCardService.findAll(page, size, sortField, sortDirection, 0);

        model.addAttribute("borrowingCards", borrowingCards);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
        return "borrowing/list";
    }

    @GetMapping("/borrow")
    public String showBorrowForm(@RequestParam("id") Long id,
                                 @RequestParam("quantity") int quantity,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (quantity > 0) {
            Book book = iBookService.findBookById(id);
            BorrowingCard borrowingCard = new BorrowingCard();
            borrowingCard.setBook(book);
            model.addAttribute("borrowingCard", borrowingCard);
            return "borrowing/borrow";
        } else {
            redirectAttributes.addFlashAttribute("message", "This book is out of stock!");
            return "redirect:/books";
        }
    }

    @PostMapping("/borrow")
    public String borrowBook(@Valid @ModelAttribute("borrowingCard") BorrowingCard borrowingCard,
                             BindingResult bindingResult,
                             Model model) {
        System.out.println(borrowingCard.getDateOfBorrow());
        new BorrowingCard().validate(borrowingCard, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("borrowingCard", borrowingCard);
            return "/borrowing/borrow";
        } else {
            BorrowingCard borrowingCard1 = iBorrowingCardService.save(borrowingCard);
            int quantity = borrowingCard.getBook().getQuantity() - 1;
            iBookService.decreaseQuantity(borrowingCard.getBook().getId(), quantity);
            model.addAttribute("borrowingCard", borrowingCard1);
            return "/borrowing/info";
        }

    }

    @GetMapping("/info")
    public ModelAndView showReturnForm(@RequestParam(value = "id", defaultValue = "0") String id,
                                       Optional<String> keyword) throws NotFoundBorrowingException {
        BorrowingCard borrowingCard;
        if (keyword.isPresent() && !keyword.get().equals("")) {
            borrowingCard = iBorrowingCardService.findOne(keyword.get());
        } else {
            borrowingCard = iBorrowingCardService.findOne(id);
        }
        return new ModelAndView("borrowing/info", "borrowingCard", borrowingCard);

    }

    @ExceptionHandler(NotFoundBorrowingException.class)
    public ModelAndView showNotFoundBorrowing() {
        return new ModelAndView("/borrowing/error");
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam("id") String id, @RequestParam("idBook") Long idBook, RedirectAttributes redirectAttributes ){
        iBorrowingCardService.returnBook(id);
        iBookService.increaseQuantity(idBook);
        redirectAttributes.addFlashAttribute("message", "Return book successfully");
        return "redirect:/borrowing";
    }


}

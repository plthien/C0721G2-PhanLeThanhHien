package com.codegym.cinemamanagement.controller;

import com.codegym.cinemamanagement.model.Movie;
import com.codegym.cinemamanagement.model.ShowTime;
import com.codegym.cinemamanagement.service.IMovieService;
import com.codegym.cinemamanagement.service.IShowTimeService;
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
@RequestMapping("/showTimes")
public class ShowTimeController {

    @Autowired
    private IShowTimeService showTimeService;

    @Autowired
    private IMovieService movieService;

    @ModelAttribute("movies")
    public List<Movie> movies() {
        return movieService.findAll();
    }

    @GetMapping()
    public String viewPageShowTimes(@RequestParam(name = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "sortField", defaultValue = "dateOfShow") String sortField,
                                    @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
                                    Optional<String> keyword,
                                    Model model
    ) {
        int size = 5;
        Page<ShowTime> showTimePage;
        if (!keyword.isPresent() || keyword.get().equals("")) {
            showTimePage = showTimeService.findAllShowTime(page, size, sortField, sortDirection);
        } else {
            showTimePage = showTimeService.findShowTimeByMovie(page, size, sortField, sortDirection, keyword.get());
            model.addAttribute("keyword", keyword.get());
        }
        model.addAttribute("showTimes", showTimePage);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "showTime", new ShowTime());
    }

    @PostMapping("/create")
    public String saveShowTime(@Valid @ModelAttribute("showTime") ShowTime showTime,
                               BindingResult bindingResult,
                               Model model) {
        System.out.println(showTime.getNumberOfTicket());
        System.out.println(showTime.getMovie().getName());
        new ShowTime().validate(showTime,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("showTime", showTime);
            System.out.println(bindingResult.toString());
            return "create";
        }
        showTime.setStatus(1);
        showTimeService.saveShowTime(showTime);
        model.addAttribute("showTime", new ShowTime());
        model.addAttribute("message", "Add new ShowTime successfully!");
        return "create";
    }

    @GetMapping("/delete{id}")
    public String deleteShowTime(@PathVariable("id") String id,
                                 RedirectAttributes redirectAttributes){
        showTimeService.deleteShowTime(id);
        redirectAttributes.addFlashAttribute("message","Delete ShowTime successfully!");
        return "redirect:/showTimes";

    }
}

package com.codegym.songmanagement.controller;

import com.codegym.songmanagement.model.Song;
import com.codegym.songmanagement.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping()
    public ModelAndView showSongList(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo){
        int size = 5;
        Page<Song> songs = iSongService.findAllSongs(pageNo,size);
        return new ModelAndView("/list","songs",songs);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return  new ModelAndView("/create","song",new Song());
    }

    @PostMapping("/create")
    public String saveSong(@Valid @ModelAttribute("song")Song song, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("song",song);

        } else {
            iSongService.save(song);
            model.addAttribute("song",new Song());
            model.addAttribute("message","Add new Song successfully!");
        }
        return "/create";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") int id){
        Song song = iSongService.findSongById(id);
        return new ModelAndView("/edit","song",song);
    }

    @PostMapping("/edit")
    public String updateSong(@Valid @ModelAttribute("song")Song song, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("song",song);
            return "/edit";
        } else {
            iSongService.save(song);
//            model.addAttribute("message","Edit Song successfully!");
        }
        return "redirect:/songs";
    }
}

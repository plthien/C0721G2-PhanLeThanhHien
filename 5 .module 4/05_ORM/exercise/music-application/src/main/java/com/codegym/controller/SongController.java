package com.codegym.controller;

import com.codegym.bean.Song;
import com.codegym.bean.SongForm;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping()
    public ModelAndView showList() {
        List<Song> songs = iSongService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list", "songs", songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("songForm",new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm, RedirectAttributes redirectAttributes) {
        System.out.println(songForm.getName());
        System.out.println(songForm.getKindOfMusic());
        System.out.println(songForm.getPath());
        MultipartFile multipartFile = songForm.getPath();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getName(),songForm.getSinger(), songForm.getKindOfMusic(),fileName);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("success", "Add new Song successfully!");
        return "redirect:/music";
    }

//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable int id){
//        Song song = iSongService.findById(id);
//        File file = new File(fileUpload + song.getPath());
//
//        SongForm songForm = new SongForm(song.getName(),song.getSinger(),song.getKindOfMusic(),file.)
//        ModelAndView modelAndView = new ModelAndView("/edit","song",song);
//        return modelAndView;
//    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable int id, RedirectAttributes redirectAttributes){
        Song song = iSongService.findById(id);
        iSongService.remove(song);
        redirectAttributes.addFlashAttribute("success","Delete song successfully!");

        return "redirect:/music";
    }
}

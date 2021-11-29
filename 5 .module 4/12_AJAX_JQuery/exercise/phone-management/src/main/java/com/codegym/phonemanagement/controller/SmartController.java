package com.codegym.phonemanagement.controller;

import com.codegym.phonemanagement.model.Smartphone;
import com.codegym.phonemanagement.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartController {
    @Autowired
    private ISmartphoneService iSmartphoneService;

    @PostMapping()
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(iSmartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        return new ModelAndView("create", "smartphones", iSmartphoneService.findAll());
    }

    @GetMapping()
    public ResponseEntity<List<Smartphone>> allPhones() {
        return new ResponseEntity<>(iSmartphoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (smartphoneOptional.isPresent()) {
            iSmartphoneService.remove(id);
            return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (smartphoneOptional.isPresent()) {
            return new ModelAndView("edit","smartphone",smartphoneOptional.get());
        } else {
            return new ModelAndView("error");

        }
    }
}

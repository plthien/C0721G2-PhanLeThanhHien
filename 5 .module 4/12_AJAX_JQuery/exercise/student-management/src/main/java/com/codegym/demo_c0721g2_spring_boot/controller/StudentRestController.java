package com.codegym.demo_c0721g2_spring_boot.controller;

import com.codegym.demo_c0721g2_spring_boot.bean.ClassRoom;
import com.codegym.demo_c0721g2_spring_boot.bean.Student;
import com.codegym.demo_c0721g2_spring_boot.dto.StudentDTO;
import com.codegym.demo_c0721g2_spring_boot.service.IClassService;
import com.codegym.demo_c0721g2_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest")
public class StudentRestController {

    @Qualifier("studentService")
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassService iClassService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> getListStudent() {
        try {
            List<Student> students =  iStudentService.findAll();
            if(students.size() == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
            }
            return new ResponseEntity<>(students,HttpStatus.OK);//200
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
    }

    @GetMapping(value = "/list_student")
    public ModelAndView getListStudent1() {
        return new ModelAndView("student/list","studentList", iStudentService.findAll());
    }

    @PostMapping(value = "/create-json")
    //@Valid: validate cho toàn bộ thuộc tính của model
    //@Validated: hỗ trợ validate 1 phần/ nhóm của model
    //BindingResult phải luôn luôn nằm ngay sau model.
    public ResponseEntity<StudentDTO> saveStudent(@Valid @RequestBody StudentDTO student) {

        iStudentService.saveDTO(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @GetMapping(value = "/create-json")
    public ModelAndView getPageCreateStudent() {
        return new ModelAndView("student/create_ajax",
                "classRooms",iClassService.findAll());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, String> handleValidationExceptions(
                MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return errors;
    }
}

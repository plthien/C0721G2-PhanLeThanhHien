package com.codegym.demo_c0721g2_spring_boot.controller;

import com.codegym.demo_c0721g2_spring_boot.bean.ClassRoom;
import com.codegym.demo_c0721g2_spring_boot.bean.Student;
import com.codegym.demo_c0721g2_spring_boot.service.IClassService;
import com.codegym.demo_c0721g2_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes("studentTalkList")
@Controller(value = "studentController2")
//Khai báo đường dẫn chung để trỏ đến controller
//@RequestMapping("student")
public class StudentController {
    //DI -> Tiêm cái lớp Implement vào interface.
    //DI -> setter
    //DI -> construstor
    @Qualifier("studentService")
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IClassService iClassService;

    @ModelAttribute("studentTalkList")
    public List<Student> createStudentTalkList() {
        return new ArrayList<>();
    }

    @GetMapping("/addTalk/{id}")
    public String addTalkList(@PathVariable(name = "id")Integer id,
                              @ModelAttribute(name = "studentTalkList")List<Student> students,
                              RedirectAttributes redirectAttributes) {
        Student student = iStudentService.findById(id);
        students.add(student);
        redirectAttributes.addFlashAttribute("msg","Add Talk List successfully");
        return "redirect:/list";
    }
//    @GetMapping("/talkStudent")
//    public String getTalkList() {
////        model.addAttribute("students", students);
//        return "student/list_talk2";
//    }


//    @GetMapping(value = "")
//    public String getPageHello(Model model) {
//        model.addAttribute("name", "Chào mừng đến với lớp C0721G2");
//        return "hello";
//    }

    @GetMapping(value = "/list")
    public String getListStudent(Model model) {
        model.addAttribute("studentList", iStudentService.findAll());
        return "student/list";
    }

    //defaultValue sẽ giúp các bạn chọn ra giá trị mặc định nếu không có giá trị đó khi gửi lên server
    @GetMapping("/list-page")
    public String getListStudentPage(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("name").ascending();//sắp xếp
        Page<Student> studentPage = iStudentService.findAll(PageRequest.of(page, 5, sort));
        model.addAttribute("studentPage", studentPage);
        return "student/list_page";
    }

    @GetMapping(value = "/detail/{id}")
    public ModelAndView getDetailStudent(@PathVariable(value = "id") Integer idStudent) throws Exception {
        Student student = iStudentService.findById(idStudent);
        if (student == null) {
            throw new Exception();
        }
        return new ModelAndView("student/detail",
                "student", student);
    }

    @GetMapping(value = "/detail")
    public String getDetailStudentByHien(@RequestParam(value = "id", defaultValue = "2") int idStudent) {
        System.out.println(idStudent);
        return "student/detail";
    }

    @GetMapping(value = "/create")
    public String getPageCreateStudent(Model model) {
        List<ClassRoom> classRooms = iClassService.findAll();
        model.addAttribute("classRooms", classRooms);
        model.addAttribute("student", new Student());
        return "student/create";
    }

    @PostMapping(value = "/create")
    //@Valid: validate cho toàn bộ thuộc tính của model
    //@Validated: hỗ trợ validate 1 phần/ nhóm của model
    //BindingResult phải luôn luôn nằm ngay sau model.
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              HttpServletResponse response,
                              Model model, @CookieValue(value = "cookieCount",defaultValue = "0") int cookieCount) {
//        new Student().validate(student,bindingResult);
        if (bindingResult.hasErrors()) {
            List<ClassRoom> classRooms = iClassService.findAll();
            model.addAttribute("classRooms", classRooms);
            return "student/create";
        }

        iStudentService.save(student);
        Cookie cookie = new Cookie("cookieCount",
                String.valueOf(cookieCount + 1));
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        redirectAttributes.addFlashAttribute("msg",
                "Create student successfully!");
        return "redirect:/list";
    }

    @GetMapping(value = "/search")
    public String searchByName(@RequestParam("searchName") String name, Model model) {
        List<Student> students = iStudentService.searchByName(name);
        model.addAttribute("studentList", students);
        return "student/list";
    }

//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "student/error_student";
//    }
}

package com.exam.demothymeleaf.controller;

import com.exam.demothymeleaf.entity.StudentEntity;
import com.exam.demothymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String getAllStudent(Model model) {
        model.addAttribute("allStudent", studentService.getAllStudent());
        model.addAttribute("studentEntity", new StudentEntity());
        return "index";
    }

    @PostMapping("/create-new-student")
    public String createNewStudent(@ModelAttribute(value = "studentEntity") StudentEntity studentEntity) {
        studentService.createNewStudent(studentEntity);
        return "redirect:/";
    }

    @GetMapping("/delete-student-by-id/{id}")
    public String deleteStudentById(@PathVariable(value = "id") Long id) throws Exception {
        studentService.deleteStudentById(id);
        return "redirect:/";
    }
}

package behw6.schoolexam.controller;

import behw6.schoolexam.entity.Student;
import behw6.schoolexam.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students",studentService.readlist());
        return "students";
    }

    @GetMapping("readdetail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        System.out.println("studentService.readdetail(id) = " + studentService.readdetail(id));
        model.addAttribute("student", studentService.readdetail(id));
        return "readdetail";
    }

    @GetMapping("/create")
    public String create(Student student) {
        return "create";
    }

    @PostMapping("create")
    public String create(@Valid Student student, BindingResult bindingResult) {
        System.out.println("student = " + student);
        if(bindingResult.hasErrors()) {
            return "create";
        }
        studentService.create(student);
        return "redirect:/students";
    }

}

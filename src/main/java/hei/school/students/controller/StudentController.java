package hei.school.students.controller;


import hei.school.students.model.Student;
import hei.school.students.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET /welcome?name=...
    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        return "Welcome " + name;
    }

    // POST /students
    @PostMapping("/students")
    public List<Student> addStudents(@RequestBody List<Student> newStudents) {
        return studentService.addStudents(newStudents);
    }

    // GET /students
    @GetMapping("/students")
    public String getStudents() {
        List<Student> students = studentService.getStudents();
        StringBuilder names = new StringBuilder();
        for (Student s : students) {
            names.append(s.toString()).append("\n");
        }
        return names.toString();
    }
}

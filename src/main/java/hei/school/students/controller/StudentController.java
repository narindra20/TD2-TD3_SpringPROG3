package hei.school.students.controller;

import hei.school.students.model.Student;
import hei.school.students.service.StudentService;
import hei.school.students.validator.StudentValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<?> addStudents(@RequestBody List<Student> newStudents) {
        try {
            for (Student s : newStudents) {
                StudentValidator.validate(s);  // validation
            }
            List<Student> students = studentService.addStudents(newStudents); // ajout
            return ResponseEntity.status(HttpStatus.CREATED).body(students);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }
}
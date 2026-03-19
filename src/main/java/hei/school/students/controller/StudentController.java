package hei.school.students.controller;

import hei.school.students.model.Student;
import hei.school.students.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET /welcome
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Paramètre 'name' manquant");
        }
        return ResponseEntity.ok("Welcome " + name);
    }

    // POST /students
    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> newStudents) {
        try {
            List<Student> students = studentService.addStudents(newStudents);
            return ResponseEntity.status(HttpStatus.CREATED).body(students);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // GET /students
    @GetMapping("/students")
    public ResponseEntity<?> getStudents(
            @RequestHeader(value = "Accept", required = false) String acceptHeader) {
        try {
            if (acceptHeader == null || acceptHeader.equals("*/*")) {
                // Cas C : header absent ou par défaut
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Header 'Accept' manquant");
            }

            List<Student> students = studentService.getStudents();

            if (acceptHeader.equals("text/plain")) {
                StringBuilder names = new StringBuilder();
                for (Student s : students) {
                    names.append(s.getFirstName()).append(" ").append(s.getLastName()).append("\n");
                }
                return ResponseEntity.ok().body(names.toString());
            } else if (acceptHeader.equals("application/json")) {
                return ResponseEntity.ok().body(students);
            } else {
                // Cas C : format non supporté
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                        .body("Format non supporté");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
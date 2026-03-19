package hei.school.students.service;

import hei.school.students.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentList = new ArrayList<>();

    public List<Student> addStudents(List<Student> newStudents) {
        studentList.addAll(newStudents);
        return studentList;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(studentList);
    }
}

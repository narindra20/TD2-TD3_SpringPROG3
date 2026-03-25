package hei.school.students.validator;

import hei.school.students.model.Student;

public class StudentValidator {

    public static void validate(Student student) throws IllegalArgumentException {
        if (student.getReference() == null || student.getReference().isBlank()) {
            throw new IllegalArgumentException("reference cannot be null or blank");
        }
        if (student.getFirstName() == null || student.getFirstName().isBlank()) {
            throw new IllegalArgumentException("firstName cannot be null or blank");
        }
        if (student.getLastName() == null || student.getLastName().isBlank()) {
            throw new IllegalArgumentException("lastName cannot be null or blank");
        }
    }
}
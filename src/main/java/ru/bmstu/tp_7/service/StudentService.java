package ru.bmstu.tp_7.service;

import ru.bmstu.tp_7.model.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student addStudent(Student student);
    Student updateTokens(Long id, int change);
    void expelStudent(Long id);
}
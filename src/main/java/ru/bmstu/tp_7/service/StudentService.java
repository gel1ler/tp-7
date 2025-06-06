package ru.bmstu.tp_7.service;

import ru.bmstu.tp_7.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getById(long id);
    void addStudent(String firstName, String lastName, int tokens);
    void addStudent(Student student);
    void updateTokens(long id, int change);
    void updateTokens(Student student, int change);
    void expelStudent(Student student);
    void expelStudent(long id);
}
package ru.bmstu.tp_7.repository;

import ru.bmstu.tp_7.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> findAll();
    Optional<Student> findById(long id);
    void add(Student student);
    void delete(Student student);
    long getNewId();
}

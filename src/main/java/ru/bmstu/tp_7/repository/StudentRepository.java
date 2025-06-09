package ru.bmstu.tp_7.repository;

import org.springframework.data.repository.CrudRepository;
import ru.bmstu.tp_7.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {}
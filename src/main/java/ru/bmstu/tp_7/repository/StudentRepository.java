package ru.bmstu.tp_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bmstu.tp_7.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
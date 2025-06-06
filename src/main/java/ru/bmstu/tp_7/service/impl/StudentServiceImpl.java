package ru.bmstu.tp_7.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.bmstu.tp_7.model.Student;
import ru.bmstu.tp_7.repository.StudentRepository;
import ru.bmstu.tp_7.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateTokens(Long id, int change) {
        Student student = getStudentById(id);
        student.setTokens(student.getTokens() + change);
        return studentRepository.save(student);
    }

    @Override
    public void expelStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
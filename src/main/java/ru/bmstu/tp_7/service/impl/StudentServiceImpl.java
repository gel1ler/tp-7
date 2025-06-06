package ru.bmstu.tp_7.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.tp_7.dto.StudentDTO;
import ru.bmstu.tp_7.model.Student;
import ru.bmstu.tp_7.model.UserRole;
import ru.bmstu.tp_7.facade.StudentFacade;
import ru.bmstu.tp_7.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentFacade studentFacade;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentFacade studentFacade) {
        this.studentRepository = studentRepository;
        this.studentFacade = studentFacade;
    }

    @Transactional(readOnly = true)
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentFacade::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StudentDTO getStudentById(Long id) {
        return studentFacade.toDTO(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found")));
    }

    public StudentDTO addStudent(String firstName, String lastName, int tokens) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setTokens(tokens);
        student.setRole(UserRole.STUDENT);
        return studentFacade.toDTO(studentRepository.save(student));
    }

    public StudentDTO updateTokens(Long id, int delta) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (student.getTokens() + delta < 0) {
            throw new RuntimeException("Tokens cannot be negative");
        }

        student.setTokens(student.getTokens() + delta);
        return studentFacade.toDTO(studentRepository.save(student));
    }

    public void expelStudent(StudentDTO studentDTO) {
        studentRepository.deleteById(studentDTO.getId());
    }
}
package ru.bmstu.tp_7.facade;

import org.springframework.stereotype.Component;
import ru.bmstu.tp_7.dto.StudentDTO;
import ru.bmstu.tp_7.model.Student;
import ru.bmstu.tp_7.model.UserRole;

@Component
public class StudentFacade {
    public StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setTokens(student.getTokens());
        dto.setRole(student.getRole());
        return dto;
    }

    public Student fromDTO(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setTokens(dto.getTokens());
        student.setRole(dto.getRole());
        return student;
    }
}
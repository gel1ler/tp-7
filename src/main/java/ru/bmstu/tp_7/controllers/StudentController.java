package ru.bmstu.tp_7.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.bmstu.tp_7.model.Student;
import ru.bmstu.tp_7.service.StudentService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/students")
public class StudentController {
    private final StudentService studentService;

    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER')")
    @Operation(summary = "Получить всех студентов", responses = {
            @ApiResponse(responseCode = "200", description = "Список студентов")
    })
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER')")
    @Operation(summary = "Получить студента по ID", responses = {
            @ApiResponse(responseCode = "200", description = "Студент найден"),
            @ApiResponse(responseCode = "404", description = "Студент не найден")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(student);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Добавить нового студента", responses = {
            @ApiResponse(responseCode = "201", description = "Студент успешно добавлен")
    })
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student saved = studentService.addStudent(student);
        return ResponseEntity
                .created(URI.create("/api/v2/students/" + saved.getId()))
                .body(saved);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @Operation(summary = "Обновить токены студента", responses = {
            @ApiResponse(responseCode = "200", description = "Токены обновлены")
    })
    @PatchMapping("/{id}/tokens")
    public ResponseEntity<Void> updateTokens(@PathVariable("id") Long id, @RequestParam("change") int change) {
        studentService.updateTokens(id, change);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize(value="hasRole('TEACHER')")
    @Operation(summary = "Удалить студента", responses = {
            @ApiResponse(responseCode = "200", description = "Студент удален")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
        studentService.expelStudent(id);
        return ResponseEntity.ok().build();
    }
}
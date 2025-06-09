package ru.bmstu.tp_7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname") // явное имя колонки
    private String firstName;

    @Column(name = "lastname")  // явное имя колонки
    private String lastName;
    private Integer tokens;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
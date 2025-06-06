package ru.bmstu.tp_7.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.bmstu.tp_7.model.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int tokens;
    private UserRole role;
}
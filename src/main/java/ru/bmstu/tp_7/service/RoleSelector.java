package ru.bmstu.tp_7.service;

import ru.bmstu.tp_7.model.UserRole;

import static ru.bmstu.tp_7.utils.InputHandler.getStringInput;
import static ru.bmstu.tp_7.utils.Menu.print;
import static ru.bmstu.tp_7.utils.Menu.println;

public class RoleSelector {
    public static UserRole selectRole() {
        while (true) {
            try {
                println("Choose your role");
                print("1 - Student\t\t2 - Teacher: ");


                String input = getStringInput().trim();

                switch (input) {
                    case "1":
                        return UserRole.STUDENT;
                    case "2":
                        return UserRole.TEACHER;
                    default:
                        println("Error");
                }
            } catch (Exception e) {
                println(e.getMessage());
            }
        }
    }
}

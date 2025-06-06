package ru.bmstu.tp_7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"ru.bmstu.tp_7",
		"ru.bmstu.tp_7.config",
		"ru.bmstu.tp_7.service"
})
public class Tp7Application {
	public static void main(String[] args) {
		SpringApplication.run(Tp7Application.class, args);
	}
}

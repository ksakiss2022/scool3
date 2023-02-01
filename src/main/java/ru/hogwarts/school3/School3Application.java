package ru.hogwarts.school3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class School3Application {

    public static void main(String[] args) {

        SpringApplication.run(School3Application.class, args);
    }

}

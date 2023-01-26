
package ru.hogwarts.school3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school3.model.Faculty;
import ru.hogwarts.school3.model.Student;
import ru.hogwarts.school3.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping //POST http://localhost:8080/facultys
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return FacultyService.createFaculty(faculty);
    }

    @GetMapping("{id}") //GET http://localhost:8080/facultys/23
    public ResponseEntity<Faculty> getfacultyInfo(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping //GET http://localhost:8080/facultys
    public ResponseEntity<Collection<Faculty>> getAllfacultys() {
        return ResponseEntity.ok(facultyService.getAllfacultys());
    }


    @PutMapping //PUT http://localhost:8080/facultys
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("{id}") //DELETE http://localhost:8080/facultys/23
    public Faculty deletFaculty(@PathVariable Long id) {
        return facultyService.deletFaculty(id);
    }

    @GetMapping("{color}") //GET http://localhost:8080/faculty/color/blue
    public ResponseEntity<Faculty> filterFacultyByColor(@PathVariable String color) {
        Faculty faculty = facultyService.filterFacultyByColor(color);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
}

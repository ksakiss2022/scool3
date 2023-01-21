
package ru.hogwarts.school3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school3.model.Student;
import ru.hogwarts.school3.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping //POST http://localhost:8080/students
    public Student createStudent(@RequestBody Student student) {
        return StudentService.createStudent(student);
    }

    @GetMapping("{id}") //GET http://localhost:8080/students/23
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping //GET http://localhost:8080/students
    public ResponseEntity<Collection<Student>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }
//    @GetMapping //GET http://localhost:8080/students/age
//    public ResponseEntity<Collection<Student>> filterStudentAge() {
//        return filterStudentAge();
//    }


    @PutMapping //PUT http://localhost:8080/students
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}") //DELETE http://localhost:8080/students/23
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deletStudent(id);
    }

}

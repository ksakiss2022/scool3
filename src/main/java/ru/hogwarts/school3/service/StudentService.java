
package ru.hogwarts.school3.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school3.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@Service
public class StudentService {
    private static final HashMap<Long, Student> students = new HashMap<>();

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    private static long lastId = 0;

    public static Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);

    }

    public static Student editStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student deletStudent(long id) {
        return students.remove(id);
    }

    public Student filterStudentByAge(int age) {
        return students.get(age);
    }
}


package ru.hogwarts.school3.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school3.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService {


    private static final HashMap<Long, Faculty> facultys = new HashMap<>();
    private static long lastId = 0;

    public Collection<Faculty> getAllfacultys() {
        return facultys.values();
    }

    public static Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        facultys.put(lastId, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return facultys.get(id);

    }

    public static Faculty editFaculty(Faculty faculty) {
        facultys.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deletFaculty(long id) {
        return facultys.remove(id);
    }


    public List<Faculty> findByByColor(String color) {
        return (List<Faculty>) facultys.get(color);
    }
}

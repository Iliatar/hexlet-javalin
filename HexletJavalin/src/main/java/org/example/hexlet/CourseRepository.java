package org.example.hexlet;

import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();
    private static long idSequence = 1;

    public static void save(Course course) {
        course.setId(getNextId());
        courses.add(course);
    }

    public static List<Course> search(String term) {
        var result = courses.stream()
                .filter(c -> c.getName().toLowerCase().startsWith(term))
                .toList();
        return result;
    }

    public static Optional<Course> find(Long id) {
        var result = courses.stream()
                .filter(c -> c.getId() == id)
                .findAny();
        return result;
    }

    public static List<Course> getEntities() { return courses; }

    private static long getNextId() { return idSequence++; }


}

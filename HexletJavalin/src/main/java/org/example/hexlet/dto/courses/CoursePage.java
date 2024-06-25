package org.example.hexlet.dto.courses;

import org.example.hexlet.model.Course;

import java.util.List;

public class CoursePage {
    private List<Course> courses;
    private String header;
    private String term;

    public CoursePage (List<Course> courses, String header, String term) {
        this.courses = courses;
        this.header = header;
        this.term = term;
    }

    public List<Course> getCourses() { return courses; }
    public String getHeader() { return header; }
    public String getTerm() { return term; }
}

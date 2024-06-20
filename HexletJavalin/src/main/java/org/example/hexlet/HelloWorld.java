package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.model.Course;

import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        Course course1 = new Course(1l, "Java", "Java developer");
        Course course2 = new Course(2l, "Frontend", "Frontend Developer");
        Course course3 = new Course(3l, "DBA", "Database Administrator");
        CoursePage coursePage = new CoursePage(List.of(course1, course2, course3), "Курсы по программированию");

        app.get("/courses/", ctx -> {
            ctx.render("summary.jte", model("coursePage", coursePage));
        });

        app.get("/courses/{id}", ctx -> {
            Long courseId = ctx.pathParamAsClass("id", Long.class).get();
            Course course = null;
            for (Course c : coursePage.getCourses()) {
                if (c.getId() == courseId) {
                    course = c;
                    break;
                }
            }
            ctx.render("course.jte", model("course", course));
        });

        app.start(7070);
    }
}

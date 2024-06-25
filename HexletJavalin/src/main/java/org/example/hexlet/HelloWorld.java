package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
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

        CourseRepository.save(new Course("Java", "Java Developer", 25000));
        CourseRepository.save(new Course("Frontend", "Frontend Developer", 22000));
        CourseRepository.save(new Course("DBA", "Database Administrator", 32000));
        CourseRepository.save(new Course("C#", "C# Backend developer", 26500));

        //TODO в шапке нужна ссылка на страницу создания курса
        //TODO добавить цену в отображение курса
        app.get("/courses/", ctx -> {
            String queryTerm = ctx.queryParam("term");
            CoursePage coursePage = new CoursePage(CourseRepository.getEntities(), "Курсы по программированию", queryTerm);
            ctx.render("summary.jte", model("coursePage", coursePage));
        });

        app.get("/courses/build", ctx -> {
            ctx.render("build.jte");
        });

        app.get("/courses/{id}", ctx -> {
            Long courseId = ctx.pathParamAsClass("id", Long.class).get();
            //TODO не работает
            Course course = CourseRepository.find(courseId).orElseThrow(() -> {
                ctx.status(404);
                return new NotFoundResponse("Курс с данным id не обнаружен");
            });
            ctx.render("course.jte", model("course", course));
        });

        //TODO добавить проверку что цена - это цифра
        app.post("/course", ctx -> {
            String name = ctx.formParam("name");
            String description = ctx.formParam("desc");
            var price = ctx.formParamAsClass("price", Double.class);

            Course newCourse = new Course(name, description, price.get());

            CourseRepository.save(newCourse);
            ctx.redirect("/courses/");
        });

        app.start(7070);
    }
}

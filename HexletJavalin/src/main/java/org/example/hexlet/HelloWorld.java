package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> ctx.result("GET/Users"));
        app.post("/users", ctx -> ctx.result("POST/Users"));

        app.get("/hello", ctx -> {
           String name = ctx.queryParam("name");
           ctx.result("Hello, " + name + "!");
        });

        app.get("/courses/{Id}", ctx -> {
           ctx.result("CourseId: " + ctx.pathParam("Id"));
        });

        app.get("/users/{Id}", ctx -> {
            ctx.result("UserId: " + ctx.pathParam("Id"));
        });

        app.get("users/{id}/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User id: " + userId + "; Post id: " + postId);
        });

        app.start(7070);
    }
}

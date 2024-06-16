package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/users", ctx -> ctx.result("GET/Users"));
        app.post("/users", ctx -> ctx.result("POST/Users"));
        app.start(7070);
    }
}

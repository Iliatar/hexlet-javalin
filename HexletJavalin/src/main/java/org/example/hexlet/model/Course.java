package org.example.hexlet.model;


public final class Course {
        private Long id;

        private String name;
        private String description;
        private double price;

        public Course(String name, String description, double price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }

        public void setId (Long id) { this.id = id; }
        public String getName() { return name; }
        public String getDescription() { return description; }
        public Long getId() { return id; }

        public String toString() {
            return "Name: " + name + "; Description: " + description;
        }
}

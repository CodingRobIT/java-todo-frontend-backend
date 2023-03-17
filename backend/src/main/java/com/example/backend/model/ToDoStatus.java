package com.example.backend.model;

public enum ToDoStatus {

    OPEN("ToDo"),
    DOING("doing"),
    DONE("done");

    private final String description;

    ToDoStatus(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ToDoStatus{" +
                "description='" + description + '\'' +
                '}';
    }
}
package com.example.backend.model;

public record ToDo(
        String id,
        String description,
        ToDoStatus status

) {
    public ToDoStatus getStatus() {
        return status;
    }


}

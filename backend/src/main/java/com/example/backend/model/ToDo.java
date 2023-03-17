package com.example.backend.model;

public record ToDo(
        String description,
        ToDoStatus status

){
    public ToDoStatus getStatus() {
        return status;
    }


}

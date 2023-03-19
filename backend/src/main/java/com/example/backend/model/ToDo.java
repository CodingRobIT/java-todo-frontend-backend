package com.example.backend.model;

import com.example.backend.status.ToDoStatus;

public record ToDo(
        String id,
        String description,
        ToDoStatus status

) {
    public ToDoStatus getStatus() {
        return status;
    }


}

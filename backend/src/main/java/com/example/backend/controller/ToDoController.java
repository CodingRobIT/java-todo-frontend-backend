package com.example.backend.controller;

import lombok.AllArgsConstructor;
import com.example.backend.model.ToDo;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@AllArgsConstructor

public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getToDos() {
        return toDoService.getTodoList();
    }


    //Kleiner test mit @PostMapping
    @PostMapping
    public ToDo addToDo(@RequestBody ToDo toDoToAdd) {
        return toDoService.addTodo(toDoToAdd);
    }


}
package com.example.backend.controller;

import com.example.backend.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.ToDoService;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
//@AllArgsConstructor
@RequiredArgsConstructor

public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getToDos() {
        return toDoService.getTodoList();
    }


    //Kleiner test mit @PostMapping
    @PostMapping
    public ToDo addToDo(@RequestBody ToDo toDoAdd) {
        return toDoService.addTodo(toDoAdd);
    }

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable String id) {
        return toDoService.getToDoById(id);
    }

    @PutMapping("/{id}")
    public ToDo changeToDoStatusById(@RequestBody ToDo todo, @PathVariable String id) {
        return  toDoService.changeToDoStatusById(todo, id);
    }

    @DeleteMapping("/{id}")
    public ToDo deletToDoById(@PathVariable String id) {
        return toDoService.deletToDoById(id);
    }

    //Test
//    @PutMapping("/undefined")
//        public ToDo changeToDoStatus(@PathVariable String id, @RequestBody ToDo toDoToUpdate) {
//        return toDoService.putToDoBy(id, toDoToUpdate);
//
//    }   //so nicht korrekt


}
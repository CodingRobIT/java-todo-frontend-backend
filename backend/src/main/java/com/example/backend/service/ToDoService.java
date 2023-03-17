package com.example.backend.service;

import com.example.backend.Repo.ToDoRepo;
import lombok.AllArgsConstructor;
import com.example.backend.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToDoService {

    private final ToDoRepo toDoRepo;

    public List<ToDo> getTodoList() {
        return toDoRepo.getTodoList();
    }


    public ToDo addTodo(ToDo toDoToAdd) {
        return toDoRepo.addTodo(new ToDo(
                toDoToAdd.description(),
                toDoToAdd.status()

        ));
    }
}

package com.example.backend.service;

import com.example.backend.Repo.ToDoRepo;
import com.example.backend.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo toDoRepo;

    public List<ToDo> getTodoList() {
        return toDoRepo.getTodoList();
    }


    public ToDo addTodo(ToDo toDoToAdd) {
        String id = UUID.randomUUID().toString();
        ToDo newToDo = new ToDo(id, toDoToAdd.description(), toDoToAdd.status());
        return toDoRepo.addTodo(newToDo);
      //  return toDoRepo.addTodo(new ToDo(toDoToAdd.id(), toDoToAdd.description(), toDoToAdd.status()));
    }

    public ToDo getToDoById(String id) {
        return toDoRepo.getTodoById(id);
    }

    public ToDo changeToDoStatusById(ToDo todo, String idRef) {
        return toDoRepo.changeToDoStatusById(todo, idRef);
    }

    public ToDo deletToDoById(String id) {
        return toDoRepo.deletToDoById(id);
    }

    //TEST
//    public ToDo putToDoBy(String id, ToDo toDoToPut) {
//        return ToDoRepo.changeToDoByIdNumber(id, toDoToPut);
//    }


}

package com.example.backend.Repo;

import com.example.backend.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ToDoRepo {

    private final Map<String, ToDo> todoList; // Map bezeichen mit wert "MAP ID" als String ist aus dem Object
                                            //ToDo_ und diese Map hat den Namen todoList

    public ToDoRepo() {
        todoList = new HashMap<>();   //und hier wird die HashMap erstellt
    }


    public List<ToDo> getTodoList() {               //Hier wird eine Liste der HashMap erstellt
        return new ArrayList<>(todoList.values());  //werte (values) der "todoList"
    }

//    public Optional<ToDo> getToDoById(String id){
//        return todoList
//                .stream()
//                .filter(toDo -> toDo.id().equals(id))
//                .findFirst();
//    }


    public ToDo addTodo(ToDo toDoToAdd) {
        todoList.put(toDoToAdd.id(), toDoToAdd);
        return toDoToAdd;
    }

    public ToDo getTodoById(String id) {
        return todoList.get(id);
    }

    public ToDo changeToDoStatusById(ToDo todo, String id) {
        todoList.put(id, todo); //Hier wird der alte Eintrag mit put überschreiben
        return todoList.get(id);
    }


//    public ToDo changeToDoByIdNumber(String id, ToDo toDoToPutUpdate){
//        ToDo toDoToDelete = getToDoById(id).orElseThrow(NoSuchElementException::new);
//        todoList.remove(toDoToDelete);
//        todoList.add(toDoToPutUpdate);
//        return toDoToPutUpdate;
//    }

//    public static ToDo changeToDoByIdNumber(String id, ToDo toDoToPut) {
//        todoList.put(toDoToPut,id);
//        return todoList.get(id);
//    }
}

package com.example.backend.Repo;

import com.example.backend.model.ToDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToDoRepo {

    private final List<ToDo> todoList;

    public ToDoRepo(List<ToDo> todoList) {
        this.todoList = todoList;
    }

    public List<ToDo> getTodoList() {
        return todoList;
    }


    public ToDo addTodo(ToDo toDoToAdd) {
        todoList.add(toDoToAdd);
        return toDoToAdd;
    }

//    public Book addBook(Book book) {
//        books.put(book.id(), book);
//        return book;
//    }
}

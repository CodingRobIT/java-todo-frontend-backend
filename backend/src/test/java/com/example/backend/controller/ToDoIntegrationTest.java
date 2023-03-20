package com.example.backend.controller;

import com.example.backend.Repo.ToDoRepo;
import com.example.backend.model.ToDo;
import com.example.backend.status.ToDoStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest  //
@AutoConfigureMockMvc
class ToDoIntegrationTest {
    //Der ToDo_ Integration Test wir im Controller erstellt in dem Fall der TodoController
    // 1. Wurde die Anfrage verstanden und angeommen vom Frontend oder Api? StatusCode -> 200
    // 2. Bekommen wir alle ToDos zurück?
    //Wenn wir alle ToDos abrufen, sollen auch alle zurück kommen!

    @Autowired
    MockMvc mockMvc;//MockMvc zum "vortäuschen" von diversen dingen wie DatenBank.

    @Autowired
    ToDoRepo toDoRepo; //Anlegen eines Fake Repos

    @Test
    void getToDos_shouldReturnEmptyToDoList_whenRepoIsEmpty() throws Exception {
        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                []
                                """));
    }

    @DirtiesContext
    @Test

    void getToDos_shouldReturnToDoList_whenRepoIsNotEmpty() throws Exception {
        ToDo toDo = new ToDo("123", "TEST ToDo", ToDoStatus.OPEN); //adden einer ToDo_ ins Fake Repo
        toDoRepo.addTodo(toDo); //und Hier wird die neue "toDo_" ins Fake Repo "toDoRepo" geaddet

        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                [                       /* Text hier muss natürlich wie oben sein */
                                    {
                                         "id": "123",
                                         "description": "TEST ToDo",
                                         "status": "OPEN"
                                    }
                                ]
                                """));
    }

    //Todo In Workprocess Integration Test
//    @Test
//    void addToDo() {
//    }
//
//    @Test
//    void getToDoById() {
//    }
//
//    @Test
//    void changeToDoStatusById() {
//    }
//
//    @Test
//    void deletToDoById() {
//    }
}
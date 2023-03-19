package com.example.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    void getToDos_shouldReturnEmptyToDoList_whenRepoIsEmpty() throws Exception {
        mockMvc.perform(get("/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                []
                                """));

        //GIVEN

        //WHEN

        //THEN
    }
    @Test
    void getToDos_shouldReturnToDoList_whenRepoIsNotEmpty() {

    }

    @Test
    void addToDo() {
    }

    @Test
    void getToDoById() {
    }

    @Test
    void changeToDoStatusById() {
    }

    @Test
    void deletToDoById() {
    }
}
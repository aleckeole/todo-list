package io.eole.todo.service.impl;

import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.persistance.entity.Todolist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodolistServiceTest {

    @Autowired
    TodolistService service;

    Todolist mondayTodo;

    @Before
    public void setUp() throws Exception {
        mondayTodo = new Todolist();
        mondayTodo.setDate(new Date());
        mondayTodo.setTitle("Liste course du lundi");

    }

    @After
    public void tearDown() throws Exception {
        service.delete(mondayTodo.getId());
    }

    @Test
    public void save() {

        TodolistDTO mondayTodoDTO = service.save(mondayTodo);
        TodolistDTO findMondayDTO = service.findOneById(mondayTodo.getId());
        assertEquals(mondayTodoDTO.getTitle(), findMondayDTO.getTitle());
    }


    @Test
    public void findOneById() {
        TodolistDTO mondayTodoDTO = service.save(mondayTodo);
        TodolistDTO findMondayTodoDTO = service.findOneById(mondayTodoDTO.getId());
        assertEquals(mondayTodoDTO.getTitle(), findMondayTodoDTO.getTitle());
    }

    @Test
    public void delete() {
        Todolist fridayTodo = new Todolist();
        fridayTodo.setDate(new Date());
        fridayTodo.setTitle("Things to do");

        TodolistDTO mondayTodoDTO = service.save(mondayTodo);
        TodolistDTO fridayTodoDTO = service.save(fridayTodo);

        List<TodolistDTO> todolistDTOs = service.findAll();
        assertTrue(todolistDTOs.size() == 2);

        service.delete(fridayTodoDTO.getId());
        todolistDTOs = service.findAll();
        assertTrue(todolistDTOs.size() != 2);

    }

    @Test
    public void findAll() {
        Todolist fridayTodo = new Todolist();
        fridayTodo.setDate(new Date());
        fridayTodo.setTitle("Things to do");

        TodolistDTO mondayTodoDTO = service.save(mondayTodo);
        TodolistDTO fridayTodoDTO = service.save(fridayTodo);

        List<TodolistDTO> todolistDTOs = service.findAll();
        assertTrue(todolistDTOs.size() == 2);
    }
}
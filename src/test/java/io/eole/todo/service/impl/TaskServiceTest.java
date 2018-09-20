package io.eole.todo.service.impl;

import io.eole.todo.dto.TaskDTO;
import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.service.ITaskService;
import io.eole.todo.service.ITodolistService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    ITaskService service;

    @Autowired
    ITodolistService todolistService;

    Task taskRiz;
    Todolist todolist;
    TodolistDTO todolistDTO;
    TaskDTO taskDTO;

    @Before
    public void setUp() throws Exception {
        taskRiz = new Task();
        todolist = new Todolist();
        todolistDTO = new TodolistDTO();
        taskDTO = new TaskDTO();

        taskRiz.setContent("Riz basmati");
        todolist.setTitle("Course de la semaine");
        todolistDTO = todolistService.save(todolist);
        taskDTO = service.saveByTodolist(taskRiz, todolist.getId());


    }

    @After
    public void tearDown() throws Exception {
        service.delete(taskRiz.getId());
        todolistService.delete(todolist.getId());
    }

    @Test
    public void saveByTodolist() {
       taskDTO = service.findOneById(taskDTO.getId());
       assertEquals(taskRiz.getContent(), taskDTO.getContent());
       assertEquals(taskDTO.getTodolist().getTitle(), todolistDTO.getTitle());

    }

    @Test
    public void findAll() {
        Task taskSoda = new Task();
        taskSoda.setContent("Cola");
        TaskDTO taskSodaDTO = service.saveByTodolist(taskSoda, todolist.getId());
        List<TaskDTO> taskDTOs = service.findAll();
        assertEquals(2, taskDTOs.size());
        assertEquals(taskSoda.getContent(), taskDTOs.get(1).getContent());
    }

    @Test
    public void delete() {
        Task taskSoda = new Task();
        taskSoda.setContent("Cola");
        TaskDTO taskSodaDTO = service.saveByTodolist(taskSoda, todolist.getId());
        List<TaskDTO> taskDTOs = service.findAll();
        assertEquals(2, taskDTOs.size());
        service.delete(taskSodaDTO.getId());
        taskDTOs = service.findAll();
        assertEquals(1, taskDTOs.size());
    }
}
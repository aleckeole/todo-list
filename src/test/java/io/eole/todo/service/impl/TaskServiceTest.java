package io.eole.todo.service.impl;

import io.eole.todo.dto.TaskDTO;
import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
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
    TaskService service;

    @Autowired
    ITodolistService todolistService;

    Task task1;
    Todolist todolist;
    TodolistDTO todolistDTO;


    @Before
    public void setUp() throws Exception {
        task1 = new Task();
        task1.setContent("Riz basmati");

        todolist = new Todolist();
        todolist.setTitle("Course de la semaine");

        task1.setTodolist(todolist);
        TaskDTO taskDTO = service.save(task1);

    }

    @After
    public void tearDown() throws Exception {
        service.delete(task1.getId());
        //todolistService.delete(todolist.getId());
    }

    @Test
    public void saveByTodolist() {
       TaskDTO taskDTO = service.findOneById(task1.getId());
       assertEquals(task1.getContent(), taskDTO.getContent());
       assertEquals(taskDTO.getTodolist().getTitle(), todolist.getTitle());

    }

   @Test
   public void save() {
       TaskDTO taskDTO = service.findOneById(task1.getId());
       assertNotNull(taskDTO);

   }

    @Test
    public void findAll() {
        Task task2 = new Task();
        task2.setContent("Cola");
        TaskDTO task2DTO = service.saveByTodolist(task2, todolist.getId());
        List<TaskDTO> tasksDTO = service.findAll();
        assertEquals(2, tasksDTO.size());
        assertEquals(task2.getContent(), tasksDTO.get(1).getContent());
        service.delete(task2.getId());
    }

    @Test
    public void delete() {
        Task task2 = new Task();
        task2.setContent("Cola");
        TaskDTO task2DTO = service.saveByTodolist(task2, todolist.getId());

        List<TaskDTO> tasksDTO = service.findAll();
        assertEquals(2, tasksDTO.size());

        service.delete(todolist.getTasks().get(1).getId());
        tasksDTO = service.findAll();
        assertEquals(1, tasksDTO.size());
    }
}
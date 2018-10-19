package io.eole.todo.service.impl;

import io.eole.todo.dto.TaskDTO;
import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.persistance.entity.Category;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.service.ICategoryService;
import io.eole.todo.service.ITaskService;
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

    @Autowired
    ITaskService taskService;

    @Autowired
    ICategoryService categoryService;

    Todolist todo1;

    @Before
    public void setUp() throws Exception {
        todo1 = new Todolist();
        todo1.setDate(new Date());
        todo1.setTitle("Liste course du lundi");
        TodolistDTO todo1DTO = service.save(todo1);
    }

    @After
    public void tearDown() throws Exception {
        service.delete(todo1.getId());
    }

    @Test
    public void save() {
        TodolistDTO todo1DTO = service.findOneById(todo1.getId());
        assertEquals(todo1.getTitle(), todo1DTO.getTitle());
    }


    @Test
    public void findOneById() {
        TodolistDTO todo1DTO = service.findOneById(todo1.getId());
        assertEquals(todo1.getTitle(), todo1DTO.getTitle());
    }

   /* @Test
    public void findOneWithTasks() {
        Task task = new Task();
        task.setContent("Coca cola");
        TaskDTO taskDTO = taskService.saveByTodolist(task, todo1.getId());

        TodolistDTO todo1DTO = service.findOneById(todo1.getId());
        assertEquals(taskDTO.getContent(), todo1DTO.getTasks().get(0).getContent());
    }*/

    @Test
    public void delete() {

        Todolist todo2 = new Todolist();
        todo2.setDate(new Date());
        todo2.setTitle("Things to do");
        TodolistDTO todo2DTO = service.save(todo2);

        List<TodolistDTO> todolistsDTO = service.findAll();
        assertTrue(todolistsDTO.size() == 2);

        service.delete(todo2.getId());
        todolistsDTO = service.findAll();
        assertTrue(todolistsDTO.size() != 2);

    }

    @Test
    public void findAll() {
        Todolist todo2 = new Todolist();
        todo2.setDate(new Date());
        todo2.setTitle("Things to do");
        TodolistDTO todo2DTO = service.save(todo2);

        List<TodolistDTO> todolistDTOs = service.findAll();
        assertTrue(todolistDTOs.size() == 2);
        service.delete(todo2DTO.getId());
    }

    @Test
    public void saveWithCategory() {
        Category category = new Category("Work", "fas fa-tachometer");
        categoryService.save(category);

        Todolist todo2 = new Todolist();
        todo2.setTitle("Test");
        todo2.setDate(new Date());
        TodolistDTO todoDTO = service.saveWithCategory(todo2, category.getId());

        assertEquals(todo2.getCategory().getTitle(), category.getTitle());
        service.delete(todo2.getId());
    }
}
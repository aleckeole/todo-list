package io.eole.todo.controller;

import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.service.ITodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolist")
public class TodolistController {

    @Autowired
    private ITodolistService service;

    @RequestMapping(method = RequestMethod.POST)
    public TodolistDTO save(@RequestBody Todolist todolist) {
        return service.save(todolist);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TodolistDTO findOneById(@PathVariable long id) {
       return service.findOneById(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<TodolistDTO> findAll() {
        return service.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/category/{idCategory}", method = RequestMethod.POST)
    public TodolistDTO saveWithCategory(@RequestBody Todolist todolist,@PathVariable long idCategory) {
        return service.saveWithCategory(todolist, idCategory);
    }
}

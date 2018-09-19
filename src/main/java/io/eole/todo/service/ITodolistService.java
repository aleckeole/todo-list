package io.eole.todo.service;

import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.persistance.entity.Todolist;

import java.util.List;

public interface ITodolistService {

    /**
     * Save a new Todolist
     * @param todolist object
     * @return TodolistDTO
     */
    public TodolistDTO save(Todolist todolist);

    /**
     * Get a Todolist by id
     * @param id of the Todolist
     * @return TodolistDTO
     */
    public TodolistDTO findOneById(long id);

    /**
     * Delete a Todolist by id
     * @param id of the Todolist
     */
    public void delete(long id);

    /**
     * Get all Todolist
     * @return list of TodolistDTO
     */
    public List<TodolistDTO> findAll();
}

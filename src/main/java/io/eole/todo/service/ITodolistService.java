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
     TodolistDTO save(Todolist todolist);

    /**
     * Get a Todolist by id
     * @param id of the Todolist
     * @return TodolistDTO
     */
     TodolistDTO findOneById(long id);

    /**
     * Delete a Todolist by id
     * @param id of the Todolist
     */
     void delete(long id);

    /**
     * Get all Todolist
     * @return list of TodolistDTO
     */
     List<TodolistDTO> findAll();

     TodolistDTO saveWithCategory(Todolist todolist, long idCategory);
}

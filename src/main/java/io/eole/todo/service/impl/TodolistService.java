package io.eole.todo.service.impl;

import io.eole.todo.dto.TaskDTO;
import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.exception.NotFoundException;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.persistance.repository.ITodolistRepository;
import io.eole.todo.service.ITodolistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodolistService implements ITodolistService {

    @Autowired
    ITodolistRepository todolistRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TodolistDTO save(Todolist todolist){

       Todolist tmp = todolistRepository.save(todolist);
       return modelMapper.map(tmp, TodolistDTO.class);
    }

    @Override
    public TodolistDTO findOneById(long id) {

        Optional<Todolist> tmp = todolistRepository.findById(id);
        if (tmp.isPresent()) {

            return modelMapper.map(tmp.get(), TodolistDTO.class);
        }
        throw new NotFoundException("Todo not found");


    }

    @Override
    public void delete(long id) {

        TodolistDTO tmp = findOneById(id);
        Todolist todolist = modelMapper.map(tmp, Todolist.class);
        todolistRepository.delete(todolist);
    }

    @Override
    public List<TodolistDTO> findAll() {

        List<Todolist> todolists = todolistRepository.findAll();
        List<TodolistDTO> todolistDTOs = new ArrayList<>();
        for (Todolist t: todolists) {
            todolistDTOs.add(modelMapper.map(t, TodolistDTO.class));
        }
        return todolistDTOs;
    }
}

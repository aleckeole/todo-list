package io.eole.todo.service.impl;


import io.eole.todo.dto.TaskDTO;
import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.exception.NotFoundException;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.persistance.repository.ITaskRepository;
import io.eole.todo.service.ITaskService;
import io.eole.todo.service.ITodolistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    ITaskRepository repository;

    @Autowired
    ITodolistService todolistService;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TaskDTO saveByTodolist(Task task, long idTodolist) {
        TodolistDTO todolistDTO = todolistService.findOneById(idTodolist);
        Todolist todolist = modelMapper.map(todolistDTO, Todolist.class);
        task.setTodolist(todolist);
        task = repository.save(task);
        return modelMapper.map(task, TaskDTO.class);

    }

    @Override
    public List<TaskDTO> findAll() {
        List<Task> tasks = repository.findAll();
        List<TaskDTO> taskDTOs = new ArrayList<>();
        for (Task task : tasks) {
            taskDTOs.add(modelMapper.map(task, TaskDTO.class));
        }
        return taskDTOs;
    }

    @Override
    public TaskDTO findOneById(long id) {
        Optional<Task> tmp = repository.findById(id);
        if (tmp.isPresent()) {
            return modelMapper.map(tmp.get(), TaskDTO.class);
        }
        throw new NotFoundException("Task not found");
    }

    @Override
    public void delete(long id) {
        TaskDTO taskDTO = findOneById(id);
        repository.deleteById(taskDTO.getId());
    }

}

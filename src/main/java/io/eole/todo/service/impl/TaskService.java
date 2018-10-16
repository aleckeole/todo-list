package io.eole.todo.service.impl;


import io.eole.todo.dto.TaskDTO;
import io.eole.todo.dto.TodolistDTO;
import io.eole.todo.exception.NotFoundException;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.persistance.repository.ITaskRepository;
import io.eole.todo.persistance.repository.ITodolistRepository;
import io.eole.todo.service.ITaskService;
import io.eole.todo.service.ITodolistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    ITodolistRepository todolistRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public TaskDTO saveByTodolist(Task task, long idTodolist) {

        Optional<Todolist> tmp = todolistRepository.findById(idTodolist);
        if (tmp.isPresent()) {
            Todolist todolist = modelMapper.map(tmp.get(), Todolist.class);
            task.setTodolist(todolist);
        }

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
        Task task = modelMapper.map(taskDTO, Task.class);
        this.repository.delete(task);
    }

    @Override
    public TaskDTO save(Task task) {
        task = repository.save(task);
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public TaskDTO setTaskValue(long id, boolean done) {
        Optional<Task> tmp = repository.findById(id);
        if(tmp.isPresent()) {
            Task task = modelMapper.map(tmp.get(), Task.class);
            task.setDone(done);
            task = repository.save(task);
            return modelMapper.map(task, TaskDTO.class);
        }
        throw new NotFoundException("Task not found");
    }
}

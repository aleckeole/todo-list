package io.eole.todo.service;

import io.eole.todo.dto.TaskDTO;
import io.eole.todo.persistance.entity.Task;

import java.util.List;

public interface ITaskService {

    public TaskDTO saveByTodolist(Task task, long idTodolist);
    public List<TaskDTO> findAll();
    public void delete(long id);
    public TaskDTO findOneById(long id);
}

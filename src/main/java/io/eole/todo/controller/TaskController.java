package io.eole.todo.controller;

import io.eole.todo.dto.TaskDTO;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private ITaskService service;

    @RequestMapping(method = RequestMethod.POST)
    public TaskDTO save(@RequestBody Task task) {
        return service.save(task);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TaskDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TaskDTO findOneById(@PathVariable long id) {
        return  service.findOneById(id);
    }

    @RequestMapping(value = "/todolist/{idTodolist}", method = RequestMethod.POST)
    public TaskDTO saveWithTodolist(@RequestBody Task task, @PathVariable long idTodolist) {
        return service.saveByTodolist(task, idTodolist);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}

package io.eole.todo.service.impl;

import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.service.ISetupService;
import io.eole.todo.service.ITaskService;
import io.eole.todo.service.ITodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetupService implements ISetupService {

    @Autowired
    ITodolistService todolistService;

    @Autowired
    ITaskService taskService;

    @Override
    public void setUp() {
        Todolist todolist = new Todolist();
        todolist.setTitle("Course de la semaine");
        todolistService.save(todolist);

        Task task1 = new Task();
        task1.setContent("Riz long grain");
        taskService.saveByTodolist(task1, todolist.getId());

        Task task2 = new Task();
        task2.setContent("Lait");
        taskService.saveByTodolist(task2, todolist.getId());

        Task task3 = new Task();
        task3.setContent("Corn-flakes"); // et oui ! Le lait avant les corn-flakes !
        taskService.saveByTodolist(task3, todolist.getId());

    }
}

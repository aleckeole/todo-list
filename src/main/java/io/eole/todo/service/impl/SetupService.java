package io.eole.todo.service.impl;

import io.eole.todo.persistance.entity.Category;
import io.eole.todo.persistance.entity.Task;
import io.eole.todo.persistance.entity.Todolist;
import io.eole.todo.service.ICategoryService;
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

    @Autowired
    ICategoryService categoryService;

    @Override
    public void setUp() {
        Todolist todolist = new Todolist();
        todolist.setTitle("Course de la semaine");

        Category cat1 = new Category("Maison", "fas fa-home");
        categoryService.save(cat1);

        todolistService.saveWithCategory(todolist, cat1.getId());

        Task task1 = new Task();
        task1.setContent("Riz long grain");
        taskService.saveByTodolist(task1, todolist.getId());

        Task task2 = new Task();
        task2.setContent("Lait");
        taskService.saveByTodolist(task2, todolist.getId());

        Task task3 = new Task();
        task3.setContent("Corn-flakes"); // Le lait avant les corn-flakes !
        taskService.saveByTodolist(task3, todolist.getId());

        /*************************************/

        Todolist todolist2 = new Todolist();
        todolist2.setTitle("Pièces inscription NY Knicks");

        Category cat2 = new Category("Business", "fas fa-briefcase");
        categoryService.save(cat2);
        todolistService.saveWithCategory(todolist2, cat2.getId());

        Task task4 = new Task();
        task4.setContent("Pièce d'identité");
        taskService.saveByTodolist(task4, todolist2.getId());

        Task task5 = new Task();
        task5.setContent("Certificat médical");
        taskService.saveByTodolist(task5, todolist2.getId());

        Task task6 = new Task();
        task6.setContent("Chèque de 250€"); // Oui il faut payer 250€ pour jouer en NBA
        taskService.saveByTodolist(task6, todolist2.getId());

        Task task7 = new Task();
        task7.setContent("Justificatif de domicile");
        taskService.saveByTodolist(task7, todolist2.getId());

        Task task8 = new Task();
        task8.setContent("RIB");
        taskService.saveByTodolist(task8, todolist2.getId());

    }
}

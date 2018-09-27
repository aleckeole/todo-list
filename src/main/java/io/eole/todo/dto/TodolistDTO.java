package io.eole.todo.dto;

import io.eole.todo.persistance.entity.Task;

import java.util.Date;
import java.util.List;

public class TodolistDTO {

    private long id;
    private Date date;
    private String title;
    private List<TaskDTO> tasks;

    public TodolistDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}

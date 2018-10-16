package io.eole.todo.dto;

import io.eole.todo.persistance.entity.Todolist;


public class TaskDTO {

    private long id;

    private String content;

    private boolean done = false;

    private Todolist todolist;

    public TaskDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Todolist getTodolist() {
        return todolist;
    }

    public void setTodolist(Todolist todolist) {
        this.todolist = todolist;
    }
}

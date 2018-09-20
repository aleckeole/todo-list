package io.eole.todo.persistance.entity;

import javax.persistence.*;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String content;

    @Column
    private boolean done = false;

    @ManyToOne
    private Todolist todolist;

    public Task() {
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

package io.eole.todo.persistance.repository;

import io.eole.todo.persistance.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodolistRepository extends JpaRepository<Todolist, Long> {
}

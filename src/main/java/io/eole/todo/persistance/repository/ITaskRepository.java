package io.eole.todo.persistance.repository;

import io.eole.todo.persistance.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}

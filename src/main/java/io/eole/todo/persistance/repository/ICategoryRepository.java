package io.eole.todo.persistance.repository;

import io.eole.todo.persistance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}

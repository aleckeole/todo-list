package io.eole.todo.persistance.repository;

import io.eole.todo.persistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}

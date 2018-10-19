package io.eole.todo.service;

import io.eole.todo.dto.CategoryDTO;
import io.eole.todo.persistance.entity.Category;

public interface ICategoryService {

    CategoryDTO save(Category category);
}

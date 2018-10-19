package io.eole.todo.service.impl;

import io.eole.todo.dto.CategoryDTO;
import io.eole.todo.persistance.entity.Category;
import io.eole.todo.persistance.repository.ICategoryRepository;
import io.eole.todo.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    ICategoryRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDTO save(Category category) {
        category = repository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }
}

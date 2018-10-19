package io.eole.todo.service.impl;

import io.eole.todo.dto.CategoryDTO;
import io.eole.todo.persistance.entity.Category;
import io.eole.todo.service.ICategoryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    ICategoryService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
        Category category = new Category("Food", "fas fa-utensils");
        CategoryDTO categoryDTO = service.save(category);
        assertEquals(category.getTitle(), categoryDTO.getTitle());
    }
}
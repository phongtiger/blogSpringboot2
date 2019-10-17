package com.example.taoblogdongianban2.service.impl;


import com.example.taoblogdongianban2.model.Category;
import com.example.taoblogdongianban2.repository.CategoryRepository;
import com.example.taoblogdongianban2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImplWithSpringData implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAllRest() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).isPresent()?categoryRepository.findById(id).get():null;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}




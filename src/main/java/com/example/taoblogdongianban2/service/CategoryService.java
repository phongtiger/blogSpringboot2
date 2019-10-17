package com.example.taoblogdongianban2.service;


import com.example.taoblogdongianban2.model.Category;

import java.util.List;

public interface CategoryService {
    Iterable<Category> findAll();
    List<Category> findAllRest();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}

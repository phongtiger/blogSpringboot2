package com.example.taoblogdongianban2.service;

import com.example.taoblogdongianban2.model.Blog;
import com.example.taoblogdongianban2.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByTittleContaining(String tittle, Pageable pageable);
    Page<Blog> findAllByCategory_Id(Long id, Pageable pageable);
    List<Blog> findAllByCategory_Id(Long id);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
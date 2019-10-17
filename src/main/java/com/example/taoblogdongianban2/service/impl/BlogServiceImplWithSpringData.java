package com.example.taoblogdongianban2.service.impl;

import com.example.taoblogdongianban2.model.Blog;
import com.example.taoblogdongianban2.model.Category;
import com.example.taoblogdongianban2.repository.BlogRepository;
import com.example.taoblogdongianban2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BlogServiceImplWithSpringData implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).isPresent()?blogRepository.findById(id).get():null;
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByTittleContaining(String tittle, Pageable pageable) {
        return blogRepository.findAllByTittleContaining(tittle, pageable);
    }

    @Override
    public Page<Blog> findAllByCategory_Id(Long id, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(id,pageable);
    }

    @Override
    public List<Blog> findAllByCategory_Id(Long id) {
        return blogRepository.findAllByCategory_Id(id);
    }

}

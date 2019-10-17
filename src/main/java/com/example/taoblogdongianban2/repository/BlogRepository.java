package com.example.taoblogdongianban2.repository;

import com.example.taoblogdongianban2.model.Blog;
import com.example.taoblogdongianban2.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByTittleContaining(String tittle, Pageable pageable);
    Page<Blog> findAllByCategory_Id(Long id, Pageable pageable);
    List<Blog> findAllByCategory_Id(Long id);
}


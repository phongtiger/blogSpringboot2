package com.example.taoblogdongianban2.controller;


import com.example.taoblogdongianban2.model.Blog;
import com.example.taoblogdongianban2.model.Category;
import com.example.taoblogdongianban2.service.BlogService;
import com.example.taoblogdongianban2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ServiceController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @ModelAttribute("categories")
    public Iterable<Category> provinces() {
        return categoryService.findAll();
    }
    @GetMapping("/rest/categories")
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories = categoryService.findAllRest();
        System.out.println(categories);
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/rest/blogs")
    public ResponseEntity<List<Blog>> listAllBlogs() {
        List<Blog> blogs = blogService.findAll();
        System.out.println(blogs);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
    @GetMapping("rest/search-category")
    public ResponseEntity<List<Blog>> listBlogByCategoryRest(@RequestParam("search") String search) {
        List<Blog> blogs = blogService.findAllByCategory_Id(Long.parseLong(search));
        System.out.println(search);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }
}

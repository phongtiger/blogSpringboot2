package com.example.taoblogdongianban2.controller;

import com.example.taoblogdongianban2.model.Blog;
import com.example.taoblogdongianban2.service.BlogService;
import com.example.taoblogdongianban2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class User {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = {"/", "/home"})
    public ModelAndView listBlogs(@RequestParam("s") Optional<String> s, Pageable pageable){
        Page<Blog> blogs;
        if(s.isPresent()){
            blogs = blogService.findAllByTittleContaining(s.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
    @PostMapping("/home/search-category")
    public ModelAndView listBlogByCategory(@ModelAttribute("blog" ) Blog blog , Pageable pageable) {
        System.out.println(blog.getCategory().getId());
        Page<Blog> blogs;
        if(blog.getId()==null){
            blogs = blogService.findAllByCategory_Id(blog.getCategory().getId(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
}

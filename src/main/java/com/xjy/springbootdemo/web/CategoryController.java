package com.xjy.springbootdemo.web;

import com.xjy.springbootdemo.dao.CategoryDAO;
import com.xjy.springbootdemo.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/categories")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort orders = Sort.by(order);
        PageRequest pageable = PageRequest.of(start, size, orders);
        Page<Category> page =categoryDAO.findAll(pageable);
        m.addAttribute("page", page);
        return "listCategory";
    }

    @PostMapping("/categories")
    public String addCategory(Category c){
        categoryDAO.save(c);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c){
        categoryDAO.delete(c);
        return "redirect:/categories";
    }

    @PutMapping("/categories/{id}")
    public String updateCategory(Category c){
        categoryDAO.save(c);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}")
    public String editCategory(@PathVariable("id") int id, Model m){
        Category c = categoryDAO.getOne(id);
        m.addAttribute("c",c);
        return "editCategory";
    }
}

package com.xjy.springbootdemo.dao;

import com.xjy.springbootdemo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    public List<Category> findByName(String name);

    public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name, int id);
}

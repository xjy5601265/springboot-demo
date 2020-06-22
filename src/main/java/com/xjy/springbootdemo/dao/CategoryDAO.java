package com.xjy.springbootdemo.dao;

import com.xjy.springbootdemo.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {

}

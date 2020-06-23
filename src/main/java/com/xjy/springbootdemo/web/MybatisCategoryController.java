package com.xjy.springbootdemo.web;

import com.xjy.springbootdemo.mapper.CategoryMapper;
import com.xjy.springbootdemo.pojo.MybatisCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MybatisCategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/listCategory2")
    public String listCategory(Model m) throws Exception {
        List<MybatisCategory> cs=categoryMapper.findAll();

        m.addAttribute("cs", cs);

        return "listCategory";
    }

}

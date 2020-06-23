package com.xjy.springbootdemo.mapper;

import java.util.List;

import com.xjy.springbootdemo.pojo.MybatisCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<MybatisCategory> findAll();

}

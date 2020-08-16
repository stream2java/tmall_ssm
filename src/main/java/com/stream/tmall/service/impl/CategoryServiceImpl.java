package com.stream.tmall.service.impl;

import com.stream.tmall.mapper.CategoryMapper;
import com.stream.tmall.pojo.Category;
import com.stream.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> list(){
        return categoryMapper.list();
    }

}

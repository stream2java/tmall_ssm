package com.stream.tmall.service;

import com.stream.tmall.pojo.Category;
import com.stream.tmall.util.Page;

import java.util.List;

public interface CategoryService{
    int total();
    List<Category> list(Page page);
    void add(Category category);
}
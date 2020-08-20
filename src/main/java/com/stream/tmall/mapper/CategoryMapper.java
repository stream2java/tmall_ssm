package com.stream.tmall.mapper;

import com.stream.tmall.pojo.Category;
import com.stream.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    public List<Category> list(Page page);
    public int total();
    void add(Category category);
    void delete(int id);
}
package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.CategoryMapper;
import com.tencent.wxcloudrun.dao.CountersMapper;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.TreeItem;
import com.tencent.wxcloudrun.service.CategoryService;
import com.tencent.wxcloudrun.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

  final CategoryMapper categoryMapper;

  public CategoryServiceImpl(@Autowired CategoryMapper categoryMapper) {
    this.categoryMapper = categoryMapper;
  }

  @Override
  public List<TreeItem> getCategoryList() {
    return categoryMapper.getCategoryList();
  }

  @Override
  public void insertCategory(Category category) {
    categoryMapper.insertCategory(category);
  }

  @Override
  public void editCategory(Category category) {
    categoryMapper.editCategory(category);
  }

  @Override
  public void deleteCategory(Integer id) {
    categoryMapper.deleteCategory(id);
  }
}

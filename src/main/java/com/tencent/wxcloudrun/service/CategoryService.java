package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.TreeItem;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

  List<TreeItem> getCategoryList();

  void insertCategory(Category category);

  void editCategory(Category category);

  void deleteCategory(Integer id);
}

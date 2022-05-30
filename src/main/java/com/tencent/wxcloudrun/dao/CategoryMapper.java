package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.TreeItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

  List<TreeItem> getCategoryList();

  void insertCategory(Category category);

  void editCategory(Category category);

  void deleteCategory(Integer id);
}

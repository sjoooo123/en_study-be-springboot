package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.TreeItem;
import com.tencent.wxcloudrun.model.Word;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

  List<TreeItem> getCategoryList();

  void insertCategory(Category category);

  void editCategory(Category category);

  void deleteCategory(Integer id);

}

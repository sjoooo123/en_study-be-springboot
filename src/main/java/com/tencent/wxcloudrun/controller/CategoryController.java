package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.TreeItem;
import com.tencent.wxcloudrun.service.CategoryService;
import com.tencent.wxcloudrun.tool.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Category控制器
 */
@RestController

public class CategoryController {

  final CategoryService categoryService;
  final Logger logger;

  public CategoryController(@Autowired CategoryService categoryService) {
    this.categoryService = categoryService;
    this.logger = LoggerFactory.getLogger(CategoryController.class);
  }

  /**
   * 获取分类列表
   * @return API response json
   */
  @GetMapping(value = "/api/category/tree")
  ApiResponse get() {
    logger.info("/api/category/tree get request");
    List<TreeItem> category = categoryService.getCategoryList();

    // 扁平列表转化为树列表
    List<TreeItem> tree = CommonUtil.list2Tree(category);

    return ApiResponse.ok(tree);
  }


  /**
   * 新增
   * @param category {@link Category}
   * @return API response json
   */
  @PostMapping(value = "/api/category/add")
  ApiResponse create(@RequestBody Category category) {
    logger.info("/api/category/add post request, {}", category);

    categoryService.insertCategory(category);

    return ApiResponse.ok();
  }

  /**
   * 修改
   * @param category {@link Category}
   * @return API response json
   */
  @PostMapping(value = "/api/category/edit")
  ApiResponse edit(@RequestBody Category category) {
    logger.info("/api/category/edit post request, {}", category);

    categoryService.editCategory(category);

    return ApiResponse.ok();
  }

  /**
   * 删除
   * @param category {@link Category}
   * @return API response json
   */
  @PostMapping(value = "/api/category/delete")
  ApiResponse delete(@RequestBody Category category) {
    logger.info("/api/category/delete post request, {}", category);

    categoryService.deleteCategory(category.getId());

    return ApiResponse.ok();
  }

}
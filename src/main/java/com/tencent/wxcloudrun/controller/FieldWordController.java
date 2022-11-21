package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.FieldWord;
import com.tencent.wxcloudrun.service.FieldWordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Word控制器
 */
@RestController

public class FieldWordController {

  final FieldWordService FieldWordService;
  final Logger logger;

  public FieldWordController(@Autowired FieldWordService FieldWordService) {
    this.FieldWordService = FieldWordService;
    this.logger = LoggerFactory.getLogger(FieldWordController.class);
  }

  /**
   * 列表（分页）
   * @param request {@link PageRequest}
   * @return API response json
   */
  @GetMapping(value = "/api/FieldWord/list")
  ApiResponse get(PageRequest request) {

    logger.info("/api/FieldWord/list get request, action: {}", request);

    Integer page = request.getPage();
    Integer size = request.getSize();
    String filtersStr = request.getFilters();
    if(filtersStr != null){
      Object filters = JSONObject.parse(filtersStr);
      request.setFiltersJSON(filters);
    }

    // 设置分页查询参数
    PageHelper.startPage(page, size);

    // 封装分页查询结果到 PageInfo 对象中以获取相关分页信息
    List<FieldWord> word = FieldWordService.getWordList(request);
    PageInfo pageInfo = new PageInfo(word);

    return ApiResponse.ok(new ResultListPage(pageInfo.getList(), pageInfo.getTotal()));
  }

  /**
   * 新增
   * @param word {@link FieldWord}
   * @return API response json
   */
  @PostMapping(value = "/api/FieldWord/add")
  ApiResponse create(@RequestBody FieldWord word) {
    logger.info("/api/FieldWord/add post request, {}", word);

    FieldWordService.insertWord(word);

    return ApiResponse.ok();
  }

  /**
   * 修改
   * @param word {@link FieldWord}
   * @return API response json
   */
  @PostMapping(value = "/api/FieldWord/edit")
  ApiResponse edit(@RequestBody FieldWord word) {
    logger.info("/api/FieldWord/edit post request, {}", word);

    FieldWordService.editWord(word);

    return ApiResponse.ok();
  }

  /**
   * 删除
   * @param word {@link FieldWord}
   * @return API response json
   */
  @PostMapping(value = "/api/FieldWord/delete")
  ApiResponse delete(@RequestBody FieldWord word) {
    logger.info("/api/FieldWord/delete post request, {}", word);

    FieldWordService.deleteWord(word.getId());

    return ApiResponse.ok();
  }

}
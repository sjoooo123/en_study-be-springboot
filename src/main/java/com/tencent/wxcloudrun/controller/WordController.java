package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Word;
import com.tencent.wxcloudrun.service.WordService;
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

public class WordController {

  final WordService WordService;
  final Logger logger;

  public WordController(@Autowired WordService WordService) {
    this.WordService = WordService;
    this.logger = LoggerFactory.getLogger(WordController.class);
  }

  /**
   * 列表（分页）
   * @param request {@link PageRequest}
   * @return API response json
   */
  @GetMapping(value = "/api/Word/list")
  ApiResponse get(PageRequest request) {

    logger.info("/api/Word/list get request, action: {}", request);

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
    List<Word> word = WordService.getWordList(request);
    PageInfo pageInfo = new PageInfo(word);

    return ApiResponse.ok(new ResultListPage(pageInfo.getList(), pageInfo.getTotal()));
  }

  /**
   * 新增
   * @param word {@link Word}
   * @return API response json
   */
  @PostMapping(value = "/api/Word/add")
  ApiResponse create(@RequestBody Word word) {
    logger.info("/api/Word/add post request, {}", word);

    WordService.insertWord(word);

    return ApiResponse.ok();
  }

  /**
   * 修改
   * @param word {@link Word}
   * @return API response json
   */
  @PostMapping(value = "/api/Word/edit")
  ApiResponse edit(@RequestBody Word word) {
    logger.info("/api/Word/edit post request, {}", word);

    WordService.editWord(word);

    return ApiResponse.ok();
  }

  /**
   * 删除
   * @param word {@link Word}
   * @return API response json
   */
  @PostMapping(value = "/api/Word/delete")
  ApiResponse delete(@RequestBody Word word) {
    logger.info("/api/Word/delete post request, {}", word);

    WordService.deleteWord(word.getId());

    return ApiResponse.ok();
  }

}
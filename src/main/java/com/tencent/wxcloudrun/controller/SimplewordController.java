package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Simpleword;
import com.tencent.wxcloudrun.service.SimplewordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Simpleword控制器
 */
@RestController

public class SimplewordController {

  final SimplewordService simplewordService;
  final Logger logger;

  public SimplewordController(@Autowired SimplewordService simplewordService) {
    this.simplewordService = simplewordService;
    this.logger = LoggerFactory.getLogger(SimplewordController.class);
  }

  /**
   * 列表（分页）
   * @param request {@link PageRequest}
   * @return API response json
   */
  @GetMapping(value = "/api/simpleword/list")
  ApiResponse get(PageRequest request) {

    logger.info("/api/simpleword/list get request, action: {}", request);

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
    List<Simpleword> simpleword = simplewordService.getSimplewordList(request);
    PageInfo pageInfo = new PageInfo(simpleword);

    return ApiResponse.ok(new ResultListPage(pageInfo.getList(), pageInfo.getTotal()));
  }

  /**
   * 新增
   * @param simpleword {@link Simpleword}
   * @return API response json
   */
  @PostMapping(value = "/api/simpleword/add")
  ApiResponse create(@RequestBody Simpleword simpleword) {
    logger.info("/api/simpleword/add post request, {}", simpleword);

    simplewordService.insertSimpleword(simpleword);

    return ApiResponse.ok();
  }

  /**
   * 修改
   * @param simpleword {@link Simpleword}
   * @return API response json
   */
  @PostMapping(value = "/api/simpleword/edit")
  ApiResponse edit(@RequestBody Simpleword simpleword) {
    logger.info("/api/simpleword/edit post request, {}", simpleword);

    simplewordService.editSimpleword(simpleword);

    return ApiResponse.ok();
  }

  /**
   * 删除
   * @param simpleword {@link Simpleword}
   * @return API response json
   */
  @PostMapping(value = "/api/simpleword/delete")
  ApiResponse delete(@RequestBody Simpleword simpleword) {
    logger.info("/api/simpleword/delete post request, {}", simpleword);

    simplewordService.deleteSimpleword(simpleword.getId());

    return ApiResponse.ok();
  }

}
package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultList;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Prefix;
import com.tencent.wxcloudrun.model.Suffix;
import com.tencent.wxcloudrun.model.Wordroot;
import com.tencent.wxcloudrun.service.SuffixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Suffix控制器
 */
@RestController

public class SuffixController {

  final SuffixService suffixService;
  final Logger logger;

  public SuffixController(@Autowired SuffixService suffixService) {
    this.suffixService = suffixService;
    this.logger = LoggerFactory.getLogger(SuffixController.class);
  }

  /**
   * 全量列表
   *
   * @return API response json
   */
  @GetMapping(value = "/api/suffix/all")
  ApiResponse get() {

    logger.info("/api/suffix/all get request");

    // 封装分页查询结果到 PageInfo 对象中以获取相关分页信息
    List<Suffix> data = suffixService.getAll();

    return ApiResponse.ok(new ResultList(data));
  }

  /**
   * 列表（分页）
   * @param request {@link PageRequest}
   * @return API response json
   */
  @GetMapping(value = "/api/suffix/list")
  ApiResponse get(PageRequest request) {

    logger.info("/api/suffix/list get request, action: {}", request);

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
    List<Suffix> suffix = suffixService.getSuffixList(request);
    PageInfo pageInfo = new PageInfo(suffix);

    return ApiResponse.ok(new ResultListPage(pageInfo.getList(), pageInfo.getTotal()));
  }

  /**
   * 新增
   * @param suffix {@link Suffix}
   * @return API response json
   */
  @PostMapping(value = "/api/suffix/add")
  ApiResponse create(@RequestBody Suffix suffix) {
    logger.info("/api/suffix/add post request, {}", suffix);

    suffixService.insertSuffix(suffix);

    return ApiResponse.ok();
  }

  /**
   * 修改
   * @param suffix {@link Suffix}
   * @return API response json
   */
  @PostMapping(value = "/api/suffix/edit")
  ApiResponse edit(@RequestBody Suffix suffix) {
    logger.info("/api/suffix/edit post request, {}", suffix);

    suffixService.editSuffix(suffix);

    return ApiResponse.ok();
  }

  /**
   * 删除
   * @param suffix {@link Suffix}
   * @return API response json
   */
  @PostMapping(value = "/api/suffix/delete")
  ApiResponse delete(@RequestBody Suffix suffix) {
    logger.info("/api/suffix/delete post request, {}", suffix);

    suffixService.deleteSuffix(suffix.getId());

    return ApiResponse.ok();
  }

}
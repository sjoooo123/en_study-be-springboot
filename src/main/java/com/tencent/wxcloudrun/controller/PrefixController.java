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
import com.tencent.wxcloudrun.service.PrefixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Prefix控制器
 */
@RestController

public class PrefixController {

  final PrefixService prefixService;
  final Logger logger;

  public PrefixController(@Autowired PrefixService prefixService) {
    this.prefixService = prefixService;
    this.logger = LoggerFactory.getLogger(PrefixController.class);
  }

  /**
   * 全量列表
   *
   * @return API response json
   */
  @GetMapping(value = "/api/prefix/all")
  ApiResponse get() {

    logger.info("/api/prefix/all get request");

    // 封装分页查询结果到 PageInfo 对象中以获取相关分页信息
    List<Prefix> data = prefixService.getAll();

    return ApiResponse.ok(new ResultList(data));
  }

  /**
   * 列表（分页）
   * @param request {@link PageRequest}
   * @return API response json
   */
  @GetMapping(value = "/api/prefix/list")
  ApiResponse get(PageRequest request) {

    logger.info("/api/prefix/list get request, action: {}", request);

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
    List<Prefix> prefix = prefixService.getPrefixList(request);
    PageInfo pageInfo = new PageInfo(prefix);

    return ApiResponse.ok(new ResultListPage(pageInfo.getList(), pageInfo.getTotal()));
  }

  /**
   * 新增
   * @param prefix {@link Prefix}
   * @return API response json
   */
  @PostMapping(value = "/api/prefix/add")
  ApiResponse create(@RequestBody Prefix prefix) {
    logger.info("/api/prefix/add post request, {}", prefix);

    prefixService.insertPrefix(prefix);

    return ApiResponse.ok();
  }

  /**
   * 修改
   * @param prefix {@link Prefix}
   * @return API response json
   */
  @PostMapping(value = "/api/prefix/edit")
  ApiResponse edit(@RequestBody Prefix prefix) {
    logger.info("/api/prefix/edit post request, {}", prefix);

    prefixService.editPrefix(prefix);

    return ApiResponse.ok();
  }

  /**
   * 删除
   * @param prefix {@link Prefix}
   * @return API response json
   */
  @PostMapping(value = "/api/prefix/delete")
  ApiResponse delete(@RequestBody Prefix prefix) {
    logger.info("/api/prefix/delete post request, {}", prefix);

    prefixService.deletePrefix(prefix.getId());

    return ApiResponse.ok();
  }

}
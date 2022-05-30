package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Prefix;
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
   * 列表（分页）
   * @param request {@link PageRequest}
   * @return API response json
   */
  @GetMapping(value = "/api/prefix/list")
  ApiResponse get(PageRequest request) {

    logger.info("/api/prefix/list get request, action: {}", request);

    Integer page = request.getPage();
    Integer size = request.getSize();
    Integer start = page * size - size;
    request.setStart(start);
    String filtersStr = request.getFilters();
    if(filtersStr != null){
      Object filters = JSONObject.parse(filtersStr);
      request.setFiltersJSON(filters);
    }

    List<Prefix> prefix = prefixService.getPrefixList(request);
    Integer total = prefixService.getPrefixListCount(request);

    return ApiResponse.ok(new ResultListPage(prefix, total));
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
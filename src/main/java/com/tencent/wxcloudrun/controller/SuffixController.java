package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Suffix;
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
   * 列表（分页）
   * @param request {@link PageRequest}
   * @return API response json
   */
  @GetMapping(value = "/api/suffix/list")
  ApiResponse get(PageRequest request) {

    logger.info("/api/suffix/list get request, action: {}", request);

    Integer page = request.getPage();
    Integer size = request.getSize();
    Integer start = page * size - size;
    request.setStart(start);
    String filtersStr = request.getFilters();
    if(filtersStr != null){
      Object filters = JSONObject.parse(filtersStr);
      request.setFiltersJSON(filters);
    }

    List<Suffix> suffix = suffixService.getSuffixList(request);
    Integer total = suffixService.getSuffixListCount(request);

    return ApiResponse.ok(new ResultListPage(suffix, total));
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
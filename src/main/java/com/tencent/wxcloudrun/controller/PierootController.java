package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultList;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Pieroot;
import com.tencent.wxcloudrun.service.PierootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Pieroot控制器
 */
@RestController

public class PierootController {

    final PierootService pierootService;
    final Logger logger;

    public PierootController(@Autowired PierootService pierootService) {
        this.pierootService = pierootService;
        this.logger = LoggerFactory.getLogger(PierootController.class);
    }

    /**
     * 全量列表
     *
     * @return API response json
     */
    @GetMapping(value = "/api/pieroot/all")
    ApiResponse get() {

        logger.info("/api/pieroot/all get request");

        // 封装分页查询结果到 PageInfo 对象中以获取相关分页信息
        List<Pieroot> pieroot = pierootService.getPierootAll();

        return ApiResponse.ok(new ResultList(pieroot));
    }

    /**
     * 列表（分页）
     *
     * @param request {@link PageRequest}
     * @return API response json
     */
    @GetMapping(value = "/api/pieroot/list")
    ApiResponse get(PageRequest request) {

        logger.info("/api/pieroot/list get request, action: {}", request);

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
        List<Pieroot> pieroot = pierootService.getPierootList(request);
        PageInfo pageInfo = new PageInfo(pieroot);
//        System.out.println("总页数: " + pageInfo.getPages());
//        System.out.println("总记录数: " + pageInfo.getTotal());
//        System.out.println("当前页数: " + pageInfo.getPageNum());
//        System.out.println("当前页面记录数量: " + pageInfo.getSize());
//        return pageInfo.getList();

        return ApiResponse.ok(new ResultListPage(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 新增
     *
     * @param pieroot {@link Pieroot}
     * @return API response json
     */
    @PostMapping(value = "/api/pieroot/add")
    ApiResponse create(@RequestBody Pieroot pieroot) {
        logger.info("/api/pieroot/add post request, {}", pieroot);

        pierootService.insertPieroot(pieroot);

        return ApiResponse.ok();
    }

    /**
     * 修改
     *
     * @param pieroot {@link Pieroot}
     * @return API response json
     */
    @PostMapping(value = "/api/pieroot/edit")
    ApiResponse edit(@RequestBody Pieroot pieroot) {
        logger.info("/api/pieroot/edit post request, {}", pieroot);

        pierootService.editPieroot(pieroot);

        return ApiResponse.ok();
    }

    /**
     * 删除
     *
     * @param pieroot {@link Pieroot}
     * @return API response json
     */
    @PostMapping(value = "/api/pieroot/delete")
    ApiResponse delete(@RequestBody Pieroot pieroot) {
        logger.info("/api/pieroot/delete post request, {}", pieroot);

        pierootService.deletePieroot(pieroot.getId());

        return ApiResponse.ok();
    }

}
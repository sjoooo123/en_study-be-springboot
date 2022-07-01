package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResultListPage;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Wordroot;
import com.tencent.wxcloudrun.service.WordrootService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Wordroot控制器
 */
@RestController

public class WordrootController {

    final WordrootService wordrootService;
    final Logger logger;

    public WordrootController(@Autowired WordrootService wordrootService) {
        this.wordrootService = wordrootService;
        this.logger = LoggerFactory.getLogger(WordrootController.class);
    }

    /**
     * 列表（分页）
     *
     * @param request {@link PageRequest}
     * @return API response json
     */
    @GetMapping(value = "/api/wordroot/list")
    ApiResponse get(PageRequest request) {

        logger.info("/api/wordroot/list get request, action: {}", request);

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
        List<Wordroot> wordroot = wordrootService.getWordrootList(request);
        PageInfo pageInfo = new PageInfo(wordroot);
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
     * @param wordroot {@link Wordroot}
     * @return API response json
     */
    @PostMapping(value = "/api/wordroot/add")
    ApiResponse create(@RequestBody Wordroot wordroot) {
        logger.info("/api/wordroot/add post request, {}", wordroot);

        wordrootService.insertWordroot(wordroot);

        return ApiResponse.ok();
    }

    /**
     * 修改
     *
     * @param wordroot {@link Wordroot}
     * @return API response json
     */
    @PostMapping(value = "/api/wordroot/edit")
    ApiResponse edit(@RequestBody Wordroot wordroot) {
        logger.info("/api/wordroot/edit post request, {}", wordroot);

        wordrootService.editWordroot(wordroot);

        return ApiResponse.ok();
    }

    /**
     * 删除
     *
     * @param wordroot {@link Wordroot}
     * @return API response json
     */
    @PostMapping(value = "/api/wordroot/delete")
    ApiResponse delete(@RequestBody Wordroot wordroot) {
        logger.info("/api/wordroot/delete post request, {}", wordroot);

        wordrootService.deleteWordroot(wordroot.getId());

        return ApiResponse.ok();
    }

}
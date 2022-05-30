package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class PageRequest {

  // 页码
  private Integer page = 1;

  // 每页大小
  private Integer size = 20;

  // limit开始
  private  Integer start = 0;

  // 关键字
  private String keyword;

  // 过滤条件-字符串
  private String filters;

  // 过滤条件-json对象
  private Object filtersJSON;
}

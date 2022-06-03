package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Category extends TreeItem {

  // 类型，词根，前缀，后缀
  private String type;
  // 排序码
  private Integer sort = 0;
  // 备注
  private String note;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}


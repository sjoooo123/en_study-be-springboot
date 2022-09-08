package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Suffix implements Serializable {

  private Integer id;

  private String affix;

  private String translation;

  private String example;

  private Integer category;

  private String frequency;

  private String note;

  private String source;

  // 完善程度：0未完善，1完善中，2已为完善
  private Integer level;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

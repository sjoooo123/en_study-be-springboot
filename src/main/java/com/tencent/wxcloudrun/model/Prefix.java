package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Prefix implements Serializable {

  private Integer id;

  private String affix;

  private String translation;

  private String example;

  private Integer category;

  private String frequency;

  private String note;

  private String source;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

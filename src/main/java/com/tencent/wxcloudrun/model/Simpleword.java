package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Simpleword implements Serializable {

  private Integer id;

  private String word;

  private String translation;

  private Integer category;

  private String note;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

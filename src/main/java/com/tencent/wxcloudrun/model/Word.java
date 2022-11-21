package com.tencent.wxcloudrun.model;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Word implements Serializable {

  private Integer id;

  private String word;

  private String phonetic;

  private String translation;

  private Integer category;

  private String grade; // 等级

  private String commonlevel;

  private String note;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

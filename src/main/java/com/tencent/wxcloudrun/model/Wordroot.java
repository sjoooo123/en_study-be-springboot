package com.tencent.wxcloudrun.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Wordroot implements Serializable {

  private Integer id;

  private String wordroot;

  private Integer pie;

  private String translation;

  private String example;

  private String category;

  private String frequency;

  private String note;

  private String source;

  private String vary;

  // 完善程度：0未完善，1完善中，2已为完善
  private Integer level;

  private String grade; // 等级

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

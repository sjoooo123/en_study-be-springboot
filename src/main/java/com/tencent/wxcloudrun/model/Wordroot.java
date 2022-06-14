package com.tencent.wxcloudrun.model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Wordroot implements Serializable {

  private Integer id;

  private String wordroot;

  private String mean;

  private String translation;

  private String example;

  private Integer category;

  private String frequency;

  private String note;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

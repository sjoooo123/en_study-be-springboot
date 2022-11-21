package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class FieldWord implements Serializable {

  private Integer id;

  private String word;

  private String translation;

  private Integer field;

  private String note;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

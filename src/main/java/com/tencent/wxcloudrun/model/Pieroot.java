package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Pieroot implements Serializable {

  private Integer id;

  private String pieroot;

  private String translation;

  private String type;

  private String chainInfo;

  private Integer category;

  private String note;

  private String vary;

  private String varyDetail;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

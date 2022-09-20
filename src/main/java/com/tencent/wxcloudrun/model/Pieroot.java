package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Pieroot implements Serializable {

  private Integer id;

  private String pieroot;

  private String translation;

  private Integer category;

  private String note;

  private String vary;

  private String varyDetail;

  // 完善程度：0未完善，1完善中，2已为完善
  private Integer level;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;
}

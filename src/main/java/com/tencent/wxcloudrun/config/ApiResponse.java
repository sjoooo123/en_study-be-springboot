package com.tencent.wxcloudrun.config;

import com.tencent.wxcloudrun.model.Category;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Optional;

@Data
public final class ApiResponse {

  private Integer code;
  private String msg;
  private Object result;

  private ApiResponse(int code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.result = data;
  }
  
  public static ApiResponse ok() {
    return new ApiResponse(1, "操作成功", new HashMap<>());
  }

  public static ApiResponse ok(Object data) {
    return new ApiResponse(1, "操作成功", data);
  }

  public static ApiResponse error(String errorMsg) {
    return new ApiResponse(0, errorMsg, new HashMap<>());
  }
}


package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.util.List;

@Data
public class TreeItem {
    private Integer id;
    private Integer pid = 0;
    private String name;
    List<TreeItem> children = null;
}

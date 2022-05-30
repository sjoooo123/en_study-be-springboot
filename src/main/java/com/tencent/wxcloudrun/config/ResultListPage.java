package com.tencent.wxcloudrun.config;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

@Data
public final class ResultListPage {
    private List list; // 每页的数据

    private long total = 0; // 总记录数


    public ResultListPage(List list, long total) {
        this.list = list;

        this.total = total;
    }
}

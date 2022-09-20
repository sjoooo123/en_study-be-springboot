package com.tencent.wxcloudrun.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public final class ResultList {
    private List list;

    public ResultList(@Autowired List list) {
        this.list = list;
    }
}

package com.tencent.wxcloudrun.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Data
public final class ResultList {
    private Optional list;

    public ResultList(@Autowired Optional list) {
        this.list = list;
    }
}

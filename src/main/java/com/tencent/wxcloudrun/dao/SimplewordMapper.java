package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Simpleword;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SimplewordMapper {

  List<Simpleword> getSimplewordList(PageRequest request);

  void insertSimpleword(Simpleword simpleword);

  void editSimpleword(Simpleword simpleword);

  void deleteSimpleword(Integer id);
}

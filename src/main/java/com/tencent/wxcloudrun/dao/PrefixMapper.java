package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Prefix;
import com.tencent.wxcloudrun.model.Wordroot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrefixMapper {

  List<Prefix> getAll();

  List<Prefix> getPrefixList(PageRequest request);

  Integer getPrefixListCount(PageRequest request);

  void insertPrefix(Prefix prefix);

  void editPrefix(Prefix prefix);

  void deletePrefix(Integer id);
}

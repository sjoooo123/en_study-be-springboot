package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Prefix;
import com.tencent.wxcloudrun.model.Suffix;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuffixMapper {

  List<Suffix> getAll();

  List<Suffix> getSuffixList(PageRequest request);

  Integer getSuffixListCount(PageRequest request);

  void insertSuffix(Suffix suffix);

  void editSuffix(Suffix suffix);

  void deleteSuffix(Integer id);
}

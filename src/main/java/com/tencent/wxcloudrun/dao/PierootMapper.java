package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Pieroot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PierootMapper {

  List<Pieroot> getPierootAll();
  List<Pieroot> getPierootList(PageRequest request);

  Integer getPierootListCount(PageRequest request);

  void insertPieroot(Pieroot pieroot);

  void editPieroot(Pieroot pieroot);

  void deletePieroot(Integer id);
}

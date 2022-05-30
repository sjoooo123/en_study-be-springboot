package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Wordroot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordrootMapper {

  List<Wordroot> getWordrootList(PageRequest request);

  Integer getWordrootListCount(PageRequest request);

  void insertWordroot(Wordroot wordroot);

  void editWordroot(Wordroot wordroot);

  void deleteWordroot(Integer id);
}

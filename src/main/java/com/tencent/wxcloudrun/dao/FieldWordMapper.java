package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.FieldWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FieldWordMapper {

  List<FieldWord> getWordList(PageRequest request);

  void insertWord(FieldWord word);

  void editWord(FieldWord word);

  void deleteWord(Integer id);
}

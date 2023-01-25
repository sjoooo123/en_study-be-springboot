package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.TreeItem;
import com.tencent.wxcloudrun.model.Word;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WordMapper {

  List<Word> getAll();
  List<Word> getWordList(PageRequest request);

  void insertWord(Word word);

  void editWord(Word word);

  void deleteWord(Integer id);
}

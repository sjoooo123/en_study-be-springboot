package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.FieldWord;

import java.util.List;

public interface FieldWordService {

  List<FieldWord> getWordList(PageRequest request);

  void insertWord(FieldWord word);

  void editWord(FieldWord word);

  void deleteWord(Integer id);
}

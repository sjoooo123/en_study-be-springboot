package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Word;

import java.util.List;

public interface WordService {

  List<Word> getWordList(PageRequest request);

  void insertWord(Word word);

  void editWord(Word word);

  void deleteWord(Integer id);
}

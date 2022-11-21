package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.CategoryMapper;
import com.tencent.wxcloudrun.dao.WordMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Word;
import com.tencent.wxcloudrun.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

  final com.tencent.wxcloudrun.dao.WordMapper WordMapper;

  public WordServiceImpl(@Autowired WordMapper WordMapper) {
    this.WordMapper = WordMapper;
  }

  @Override
  public List<Word> getWordList(PageRequest request) {
    return WordMapper.getWordList(request);
  }

  @Override
  public void insertWord(Word word) {
    WordMapper.insertWord(word);
  }

  @Override
  public void editWord(Word word) {
    WordMapper.editWord(word);
  }

  @Override
  public void deleteWord(Integer id) {
    WordMapper.deleteWord(id);
  }

}

package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.FieldWordMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.FieldWord;
import com.tencent.wxcloudrun.service.FieldWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldWordServiceImpl implements FieldWordService {

  final FieldWordMapper FieldWordMapper;

  public FieldWordServiceImpl(@Autowired FieldWordMapper FieldWordMapper) {
    this.FieldWordMapper = FieldWordMapper;
  }

  @Override
  public List<FieldWord> getWordList(PageRequest request) {
    return FieldWordMapper.getWordList(request);
  }

  @Override
  public void insertWord(FieldWord word) {
    FieldWordMapper.insertWord(word);
  }

  @Override
  public void editWord(FieldWord word) {
    FieldWordMapper.editWord(word);
  }

  @Override
  public void deleteWord(Integer id) {
    FieldWordMapper.deleteWord(id);
  }

}

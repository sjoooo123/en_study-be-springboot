package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.WordrootMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Wordroot;
import com.tencent.wxcloudrun.service.WordrootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordrootServiceImpl implements WordrootService {

  final WordrootMapper wordrootMapper;

  public WordrootServiceImpl(@Autowired WordrootMapper wordrootMapper) {
    this.wordrootMapper = wordrootMapper;
  }

  @Override
  public List<Wordroot> getAll() {
    return wordrootMapper.getAll();
  }

  @Override
  public List<Wordroot> getWordrootList(PageRequest request) {
    return wordrootMapper.getWordrootList(request);
  }

  @Override
  public void insertWordroot(Wordroot wordroot) {
    wordrootMapper.insertWordroot(wordroot);
  }

  @Override
  public void editWordroot(Wordroot wordroot) {
    wordrootMapper.editWordroot(wordroot);
  }

  @Override
  public void deleteWordroot(Integer id) {
    wordrootMapper.deleteWordroot(id);
  }

}

package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PrefixMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Prefix;
import com.tencent.wxcloudrun.model.Wordroot;
import com.tencent.wxcloudrun.service.PrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrefixServiceImpl implements PrefixService {

  final PrefixMapper prefixMapper;

  public PrefixServiceImpl(@Autowired PrefixMapper prefixMapper) {
    this.prefixMapper = prefixMapper;
  }

  @Override
  public List<Prefix> getAll() {
    return prefixMapper.getAll();
  }

  @Override
  public List<Prefix> getPrefixList(PageRequest request) {
    return prefixMapper.getPrefixList(request);
  }

  @Override
  public void insertPrefix(Prefix prefix) {
    prefixMapper.insertPrefix(prefix);
  }

  @Override
  public void editPrefix(Prefix prefix) {
    prefixMapper.editPrefix(prefix);
  }

  @Override
  public void deletePrefix(Integer id) {
    prefixMapper.deletePrefix(id);
  }

}

package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.SuffixMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Suffix;
import com.tencent.wxcloudrun.service.SuffixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuffixServiceImpl implements SuffixService {

  final SuffixMapper suffixMapper;

  public SuffixServiceImpl(@Autowired SuffixMapper suffixMapper) {
    this.suffixMapper = suffixMapper;
  }

  @Override
  public List<Suffix> getSuffixList(PageRequest request) {
    return suffixMapper.getSuffixList(request);
  }

  @Override
  public void insertSuffix(Suffix suffix) {
    suffixMapper.insertSuffix(suffix);
  }

  @Override
  public void editSuffix(Suffix suffix) {
    suffixMapper.editSuffix(suffix);
  }

  @Override
  public void deleteSuffix(Integer id) {
    suffixMapper.deleteSuffix(id);
  }

}

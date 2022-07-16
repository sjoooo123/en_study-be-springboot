package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.SimplewordMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Simpleword;
import com.tencent.wxcloudrun.service.SimplewordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimplewordServiceImpl implements SimplewordService {

  final SimplewordMapper simplewordMapper;

  public SimplewordServiceImpl(@Autowired SimplewordMapper simplewordMapper) {
    this.simplewordMapper = simplewordMapper;
  }

  @Override
  public List<Simpleword> getSimplewordList(PageRequest request) {
    return simplewordMapper.getSimplewordList(request);
  }

  @Override
  public void insertSimpleword(Simpleword simpleword) {
    simplewordMapper.insertSimpleword(simpleword);
  }

  @Override
  public void editSimpleword(Simpleword simpleword) {
    simplewordMapper.editSimpleword(simpleword);
  }

  @Override
  public void deleteSimpleword(Integer id) {
    simplewordMapper.deleteSimpleword(id);
  }

}

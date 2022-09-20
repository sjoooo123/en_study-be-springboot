package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PierootMapper;
import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Pieroot;
import com.tencent.wxcloudrun.service.PierootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PierootServiceImpl implements PierootService {

  final PierootMapper pierootMapper;

  public PierootServiceImpl(@Autowired PierootMapper pierootMapper) {
    this.pierootMapper = pierootMapper;
  }

  @Override
  public List<Pieroot> getPierootAll() {
    return pierootMapper.getPierootAll();
  }

  @Override
  public List<Pieroot> getPierootList(PageRequest request) {
    return pierootMapper.getPierootList(request);
  }

  @Override
  public void insertPieroot(Pieroot pieroot) {
    pierootMapper.insertPieroot(pieroot);
  }

  @Override
  public void editPieroot(Pieroot pieroot) {
    pierootMapper.editPieroot(pieroot);
  }

  @Override
  public void deletePieroot(Integer id) {
    pierootMapper.deletePieroot(id);
  }

}

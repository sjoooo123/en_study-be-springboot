package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Pieroot;

import java.util.List;

public interface PierootService {

  List<Pieroot> getPierootAll();

  List<Pieroot> getPierootList(PageRequest request);

  void insertPieroot(Pieroot wordroot);

  void editPieroot(Pieroot wordroot);

  void deletePieroot(Integer id);
}

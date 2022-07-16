package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Simpleword;

import java.util.List;

public interface SimplewordService {

  List<Simpleword> getSimplewordList(PageRequest request);

  void insertSimpleword(Simpleword simpleword);

  void editSimpleword(Simpleword simpleword);

  void deleteSimpleword(Integer id);
}

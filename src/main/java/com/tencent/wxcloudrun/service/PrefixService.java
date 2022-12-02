package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Prefix;
import com.tencent.wxcloudrun.model.Wordroot;

import java.util.List;

public interface PrefixService {

  List<Prefix> getAll();

  List<Prefix> getPrefixList(PageRequest request);

  void insertPrefix(Prefix prefix);

  void editPrefix(Prefix prefix);

  void deletePrefix(Integer id);
}

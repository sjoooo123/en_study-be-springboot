package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Suffix;

import java.util.List;

public interface SuffixService {

  List<Suffix> getSuffixList(PageRequest request);

  Integer getSuffixListCount(PageRequest request);

  void insertSuffix(Suffix suffix);

  void editSuffix(Suffix suffix);

  void deleteSuffix(Integer id);
}

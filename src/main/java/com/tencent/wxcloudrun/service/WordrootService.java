package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.PageRequest;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.Wordroot;

import java.util.List;
import java.util.Optional;

public interface WordrootService {

  List<Wordroot> getWordrootList(PageRequest request);

  void insertWordroot(Wordroot wordroot);

  void editWordroot(Wordroot wordroot);

  void deleteWordroot(Integer id);
}

package com.tencent.wxcloudrun.tool;

import com.tencent.wxcloudrun.model.TreeItem;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class CommonUtil {

    //sourceList 平铺的原始数据集合
    public static List<TreeItem> list2Tree(List<TreeItem> sourceList) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        }
        List<TreeItem> resultList = new ArrayList<>();
        //将数据封装成树形结构
        Map<Integer, TreeItem> map = new HashMap<>();
        for (TreeItem data : sourceList) {
            map.put(data.getId(), data);
        }
        for (TreeItem data : sourceList) {
            TreeItem obj = map.get(data.getPid());
            if (obj != null) {
                List<TreeItem> children = obj.getChildren();
                if (children == null || children.isEmpty()) {
                    children = new ArrayList<>();
                }
                children.add(data);
                obj.setChildren(children);

            } else {
                resultList.add(data);
            }

        }
        return resultList;
    }

}

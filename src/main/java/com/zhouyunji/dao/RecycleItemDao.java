package com.zhouyunji.dao;

import com.zhouyunji.bean.recycle.RecycleItem;
import com.zhouyunji.bean.recycle.RecycleOrderPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecycleItemDao {
    void insertRecycleItem(RecycleItem recycleItem);

    List<RecycleItem> queryItemsByOrderId(String orderId);
}

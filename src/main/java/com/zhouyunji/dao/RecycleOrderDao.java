package com.zhouyunji.dao;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.recycle.RecycleOrderPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecycleOrderDao {
    void insertRecycleOrder(RecycleOrderPo recycleOrderPo);

    RecycleOrderPo queryOrdersByUserIdAndStatus(String userId,int status);
}

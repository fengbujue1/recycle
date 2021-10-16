package com.zhouyunji.dao;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.recycle.RecycleOrderPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecycleOrderDao {
    void insertRecycleOrder(RecycleOrderPo recycleOrderPo);

    List<RecycleOrderPo> queryOrdersByUserIdAndStatus(@Param("userId") String userId, @Param("status")int status);
}

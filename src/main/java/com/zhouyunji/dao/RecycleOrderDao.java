package com.zhouyunji.dao;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.recycle.RecycleOrderPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecycleOrderDao {
    void insertRecycleOrder(RecycleOrderPo recycleOrderPo);
    void updateStatus(Integer status,String orderId);

    List<RecycleOrderPo> queryOrdersByUserIdAndStatus(@Param("openid") String openid, @Param("status")int status);
}

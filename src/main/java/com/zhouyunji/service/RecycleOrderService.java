package com.zhouyunji.service;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.recycle.RecycleItem;
import com.zhouyunji.bean.recycle.RecycleOrderPo;
import com.zhouyunji.bean.recycle.RecycleOrderVo;
import com.zhouyunji.bean.recycle.enmu.OrderStatus;
import com.zhouyunji.dao.AddressDao;
import com.zhouyunji.dao.RecycleItemDao;
import com.zhouyunji.dao.RecycleOrderDao;
import com.zhouyunji.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecycleOrderService {
    @Autowired
    RecycleOrderDao recycleOrderDao;
    @Autowired
    RecycleItemDao recycleItemDao;

    @Transactional
    public void submitOrder(RecycleOrderVo recycleOrderVo) {
        if (OrderStatus.getStatusByCode(recycleOrderVo.getStatus()) != OrderStatus.NOT_ACCEPT) {
            throw new RuntimeException("错误的初始订单状态:" + recycleOrderVo.getStatus());
        }
        RecycleOrderPo recycleOrderPo = new RecycleOrderPo();
        recycleOrderDao.insertRecycleOrder(recycleOrderPo);
        List<RecycleItem> items = recycleOrderVo.getItems();
        if (items.size() > 0) {
            for (RecycleItem recycleItem : items) {
                recycleItemDao.insertRecycleItem(recycleItem);
            }
        }
    }

    @Transactional
    public RecycleOrderVo queryOrders(String userId, int status) {
        OrderStatus orderStatus = OrderStatus.getStatusByCode(status);
        RecycleOrderPo recycleOrderPo = recycleOrderDao.queryOrdersByUserIdAndStatus(userId, orderStatus.statusCode());
        //vo
        List<RecycleItem> recycleItems = recycleItemDao.queryItemsByOrderId(recycleOrderPo.getId());

        return ;
    }
}

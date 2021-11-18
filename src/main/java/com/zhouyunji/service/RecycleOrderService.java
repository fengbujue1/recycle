package com.zhouyunji.service;

import com.zhouyunji.bean.recycle.RecycleItem;
import com.zhouyunji.bean.recycle.RecycleOrderPo;
import com.zhouyunji.bean.recycle.RecycleOrderVo;
import com.zhouyunji.bean.recycle.enmu.OrderStatus;
import com.zhouyunji.dao.RecycleItemDao;
import com.zhouyunji.dao.RecycleOrderDao;
import com.zhouyunji.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RecycleOrderService {
    @Autowired
    RecycleOrderDao recycleOrderDao;
    @Autowired
    RecycleItemDao recycleItemDao;

    @Transactional
    public void submitOrder(RecycleOrderVo recycleOrderVo) throws ParseException {
        UUID uuid = UUID.randomUUID();
        RecycleOrderPo recycleOrderPo = new RecycleOrderPo();
        recycleOrderPo.setOrderId(uuid.toString());
        //        重新转换时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        recycleOrderVo.setTime(simpleDateFormat.parse(recycleOrderVo.getTimeStr()));
        BeanCopyUtil.copyProperties(recycleOrderVo, recycleOrderPo, "");
//        初始提交的订单，状态都为1
        recycleOrderPo.setStatus(1);


        recycleOrderDao.insertRecycleOrder(recycleOrderPo);
        List<RecycleItem> items = recycleOrderVo.getItems();
        if (items.size() > 0) {
            for (RecycleItem recycleItem : items) {
                recycleItem.setOrderId(uuid.toString());
                recycleItemDao.insertRecycleItem(recycleItem);
            }
        }
    }

    @Transactional
    public List<RecycleOrderVo> queryOrders(String userId, int status) {
        OrderStatus orderStatus = OrderStatus.getStatusByCode(status);
        List<RecycleOrderPo> recycleOrderPos = recycleOrderDao.queryOrdersByUserIdAndStatus(userId, orderStatus.statusCode());

        ArrayList<RecycleOrderVo> recycleOrderVos = new ArrayList<>();
        for (int i = 0; i < recycleOrderPos.size(); i++) {
            RecycleOrderPo recycleOrderPo = recycleOrderPos.get(i);
            List<RecycleItem> recycleItems = recycleItemDao.queryItemsByOrderId(recycleOrderPo.getOrderId());
            RecycleOrderVo recycleOrderVo = new RecycleOrderVo();
            BeanCopyUtil.copyProperties(recycleOrderPo, recycleOrderVo, "");
            recycleOrderVo.setItems(recycleItems);
            recycleOrderVos.add(recycleOrderVo);
        }
        return recycleOrderVos;
    }
}

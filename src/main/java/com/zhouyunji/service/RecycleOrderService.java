package com.zhouyunji.service;

import com.zhouyunji.bean.recycle.RecycleItem;
import com.zhouyunji.bean.recycle.RecycleOrderPo;
import com.zhouyunji.bean.recycle.RecycleOrderVo;
import com.zhouyunji.bean.recycle.enmu.OrderStatus;
import com.zhouyunji.bean.recycle.enmu.RecycleKindByType;
import com.zhouyunji.bean.recycle.enmu.WeightRange;
import com.zhouyunji.dao.AddressDao;
import com.zhouyunji.dao.RecycleItemDao;
import com.zhouyunji.dao.RecycleOrderDao;
import com.zhouyunji.util.BeanCopyUtil;
import com.zhouyunji.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RecycleOrderService {
    @Autowired
    RecycleOrderDao recycleOrderDao;
    @Autowired
    RecycleItemDao recycleItemDao;
    @Autowired
    AddressDao addressDao;

    @Transactional
    public void submitOrder(RecycleOrderVo recycleOrderVo) throws ParseException {
        RecycleOrderPo recycleOrderPo = new RecycleOrderPo();

        //        重新转换时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if ("尽快上门".equals(recycleOrderVo.getTimeStr())) {
            recycleOrderVo.setTime(null);
        } else {
            recycleOrderVo.setTime(simpleDateFormat.parse(recycleOrderVo.getTimeStr()));
        }
        recycleOrderVo.setSubmitTime(new Date());

        BeanCopyUtil.copyProperties(recycleOrderVo, recycleOrderPo, "");
        UUID uuid = UUID.randomUUID();
        recycleOrderPo.setOrderId(uuid.toString());
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
//            订单时间数据转换
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if (recycleOrderVo.getTime() == null) {
                recycleOrderVo.setTimeStr("尽快上门");
            } else {

                recycleOrderVo.setTimeStr(simpleDateFormat.format(recycleOrderVo.getTime()));
            }
            recycleOrderVo.setSubmitTimeStr(simpleDateFormat.format(recycleOrderVo.getSubmitTime()));


            //订单item名称转换
            transItemName(recycleItems);
            recycleOrderVo.setItems(recycleItems);
            recycleOrderVo.setAddressStr(addressDao.getAddressStrById(recycleOrderVo.getAddressId()));
            recycleOrderVos.add(recycleOrderVo);
        }
        return recycleOrderVos;
    }

    /**
     *
     * @param orderId
     * @return
     */
    public List<RecycleOrderVo> cancelOrder(String orderId,String userId, int currentStatusIndex) {
        recycleOrderDao.updateStatus(OrderStatus.CANCLED.statusCode(),orderId);
        return queryOrders(userId, currentStatusIndex);

    }

    private void transItemName(List<RecycleItem> recycleItems) {
        for (RecycleItem recycleItem : recycleItems) {
            recycleItem.setRecycleKindStr(RecycleKindByType.getRecycleKindStrByCode(recycleItem.getRecycleKind()));
            recycleItem.setWeightRangeStr(WeightRange.getWeightRangeStrByRangeCode(recycleItem.getWeightRange()));

        }
    }
}

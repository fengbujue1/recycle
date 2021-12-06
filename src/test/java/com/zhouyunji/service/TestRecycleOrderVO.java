package com.zhouyunji.service;

import com.alibaba.fastjson.JSON;
import com.zhouyunji.bean.recycle.RecycleItem;
import com.zhouyunji.bean.recycle.RecycleOrderVo;
import com.zhouyunji.bean.recycle.enmu.WeightRange;
import com.zhouyunji.bean.recycle.enmu.OrderStatus;
import com.zhouyunji.bean.recycle.enmu.RecycleKindByType;
import com.zhouyunji.bean.recycle.enmu.RecycleType;

import java.util.ArrayList;
import java.util.Date;

public class TestRecycleOrderVO {
    public static void main(String[] args) {
        RecycleOrderVo recycleOrderVo = new RecycleOrderVo();
        recycleOrderVo.setAddressId(3);
        recycleOrderVo.setRecycleType(RecycleType.WASTE_PAPE.typeCode());
        recycleOrderVo.setRemark("asdasdasdad");
        recycleOrderVo.setStatus(OrderStatus.NOT_ACCEPT.statusCode());
        recycleOrderVo.setTime(new Date());

        ArrayList<RecycleItem> recycleItems = new ArrayList<>();
        RecycleItem recycleItem = new RecycleItem();
        recycleItem.setWeightRange(WeightRange.RANGE1.getRangeCode());
        recycleItem.setRecycleKind(RecycleKindByType.MIXTURE_PAPE.typeCode());
        recycleItems.add(recycleItem);
        recycleOrderVo.setItems(recycleItems);

        System.out.println(JSON.toJSONString(recycleOrderVo));
    }
}

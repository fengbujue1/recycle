package com.zhouyunji.controller;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.recycle.RecycleOrderVo;
import com.zhouyunji.bean.recycle.enmu.OrderStatus;
import com.zhouyunji.dao.RecycleOrderDao;
import com.zhouyunji.service.AddressService;
import com.zhouyunji.service.RecycleOrderService;
import com.zhouyunji.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 回收
 */
@Controller()
@RequestMapping("/recycle")
public class RecycleOrderController {
    @Autowired
    RecycleOrderService recycleOrderService;
    /**
     * 回收下单
     * @param recycleOrderVo 预约信息
     * @return
     */
    @PutMapping(value = "/submit",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String submit(@RequestBody RecycleOrderVo recycleOrderVo) {

        String result = "fail";
        try {
            recycleOrderService.submitOrder(recycleOrderVo);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 订单查询
     * @param userId
     * @param status
     * @return
     */
    @GetMapping(value = "/query")
    @ResponseBody
    public List<RecycleOrderVo> query(String userId, int status) {
        return recycleOrderService.queryOrders(userId, status);
    }

    /**
     * 取消订单
     */
    @DeleteMapping(value = "/delete")
    @ResponseBody
    public List<RecycleOrderVo> delete(String orederId, Integer currentStatusIndex, String userId) {
        if (currentStatusIndex > OrderStatus.ACCEPTED.statusCode()) {
            throw new RuntimeException("当前状态订单不可取消");
        }
        return recycleOrderService.cancelOrder(orederId, userId, currentStatusIndex);

    }
}

package com.zhouyunji.controller;

import com.zhouyunji.bean.recycle.RecycleOrderVo;
import com.zhouyunji.bean.recycle.enmu.OrderStatus;
import com.zhouyunji.service.RecycleOrderService;
import com.zhouyunji.util.TokenUtil;
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
     * @param token
     * @param status
     * @return
     */
    @GetMapping(value = "/query")
    @ResponseBody
    public List<RecycleOrderVo> query(String token, int status) throws Exception {
        String openId = TokenUtil.analysisToken(token);
        return recycleOrderService.queryOrders(openId, status);
    }

    /**
     * 取消订单
     */
    @DeleteMapping(value = "/delete")
    @ResponseBody
    public List<RecycleOrderVo> delete(String orederId, Integer currentStatusIndex, String token) throws Exception {
        if (currentStatusIndex > OrderStatus.ACCEPTED.statusCode()) {
            throw new RuntimeException("当前状态订单不可取消");
        }
        String openId = TokenUtil.analysisToken(token);
        return recycleOrderService.cancelOrder(orederId, openId, currentStatusIndex);

    }
}

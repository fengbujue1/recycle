package com.zhouyunji.controller;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.recycle.RecycleType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 个人地址管理
 */
@Controller()
@RequestMapping("/recycle")
public class RecycleController {
    /**
     * 更新个人收货地址
     * @param address 新地址
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public String updateAddress(Address address) {
        String result = "fail";
        try {
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

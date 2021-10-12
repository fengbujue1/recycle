package com.zhouyunji.controller;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.recycle.RecycleType;
import com.zhouyunji.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 个人地址管理
 */
@Controller()
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    /**
     * 新增收货地址
     * @param address
     * @param session
     * @param response
     * @return
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public String addAddress(Address address, HttpSession session, HttpServletResponse response) {
        String result = "fail";
        try {
            addressService.addAddress(address);
            result ="success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询个人已有收货地址
     * @param userId  用户id
     * @return
     */
    @GetMapping(value = "/query")
    @ResponseBody
    public List<Address> queryAllAddresses(Integer userId) {
        return addressService.queryAddresses(userId);
    }

    /**
     * 删除收货地址
     *
     * @param id 地址id
     * @return
     */
    @DeleteMapping(value = "/delete")
    @ResponseBody
    public String deleteAddress(Integer id) {
        String result = "fail";
        try {
            addressService.deleteAddress(id);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 更新个人收货地址
     *
     * TODO 先全量更新，如果前端传太多冗余数据觉得不方便，可以指定字段更新
     * @param address 新地址
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public String updateAddress(Address address) {
        String result = "fail";
        try {
            addressService.updateAddress(address);
            result = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

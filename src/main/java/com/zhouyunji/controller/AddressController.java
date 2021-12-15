package com.zhouyunji.controller;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.service.AddressService;
import com.zhouyunji.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @Autowired
    HttpServletRequest request;//todo 不会有并发问题？
    /**
     * 新增收货地址
     * @param address
     * @param session
     * @param response
     * @return
     */
    @PutMapping(value = "/add")
    @ResponseBody
    public String addAddress( @RequestBody Address address, HttpSession session, HttpServletResponse response) {
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
     *
     * @return
     */
    @GetMapping(value = "/query")
    @ResponseBody
    public List<Address> queryAllAddresses() throws Exception {
        String token = request.getHeader("token");
        String openid = TokenUtil.analysisToken(token);
        return addressService.queryAddresses(openid);
    }

    /**
     * 删除收货地址
     * 并且返回新的地址列表
     *
     * @param id 地址id
     * @return
     */
    @PostMapping(value = "/delete/{id}")
    @ResponseBody
    public  String deleteAddress(@PathVariable Integer id) {
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
    public String updateAddress(@RequestBody Address address) {
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

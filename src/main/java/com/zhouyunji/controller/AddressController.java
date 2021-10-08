package com.zhouyunji.controller;

import com.zhouyunji.bean.Address;
import com.zhouyunji.bean.FormData;
import com.zhouyunji.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 个人地址管理
 */
@Controller("/address")
public class AddressController {
    @Autowired
    AddressService addressService;
    /**
     * 新增地址
     * @param address
     * @param session
     * @param response
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public String addAddress(Address address, HttpSession session, HttpServletResponse response) {
        addressService.addAddress(address);
        return "success";
    }
}

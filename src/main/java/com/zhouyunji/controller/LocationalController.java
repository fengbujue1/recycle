package com.zhouyunji.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.zhouyunji.bean.Address;
import com.zhouyunji.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 地址管理
 */
@Controller("/location")
public class LocationalController {
    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String addAddress(Address address, HttpSession session, HttpServletResponse response) {
        Map locationMaps = locationService.getLocationMaps();
        return JSON.toJSONString(locationMaps);
    }

}

package com.zhouyunji.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.zhouyunji.bean.Address;
import com.zhouyunji.bean.LocationWapper;
import com.zhouyunji.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 地址管理
 */
@Controller()
@RequestMapping("/location")
public class LocationalController {
    @Autowired
    LocationService locationService;

    /**
     * 查询 行政地址划分
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Object addAddress() {
        Map locationMaps = locationService.getLocationMaps();
        LocationWapper locationWapper = new LocationWapper(locationMaps);
        return locationWapper;
    }

}

package com.zhouyunji.controller;

import com.alibaba.fastjson.JSON;
import com.zhouyunji.bean.address.LocationWapper;
import com.zhouyunji.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return JSON.toJSONString(locationWapper);
    }

}

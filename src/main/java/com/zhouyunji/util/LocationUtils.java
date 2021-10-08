package com.zhouyunji.util;

import com.zhouyunji.bean.Location;

import java.util.Map;

public class LocationUtils {
    private static Map<Location, Object> locationMap;
    public static Map<Location, Object> getLocationMap() {
        return locationMap;
    }
    public static void setLocationMap(Map<Location, Object> newLocationMap) {
        locationMap=newLocationMap;
    }
}

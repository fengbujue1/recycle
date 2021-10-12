package com.zhouyunji.bean.address;

import java.util.Map;

public class LocationWapper {

    private Map locations;

    public LocationWapper(Map locations) {
        this.locations = locations;
    }

    public Map getLocations() {
        return locations;
    }

    public void setLocations(Map locations) {
        this.locations = locations;
    }
}

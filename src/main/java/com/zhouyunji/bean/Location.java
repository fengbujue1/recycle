package com.zhouyunji.bean;

/**
 * 地址
 */
public class Location {
    private Integer id;//地址唯一id
    private Integer parentId;//父级地址Id （省级地址的parentId为0）
    private String locationName;//地址名字

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}

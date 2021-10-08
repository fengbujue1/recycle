package com.zhouyunji.dao;

import com.zhouyunji.bean.Location;

import java.util.List;

public interface LocationDao {
    List<Location> getLocationsByParentId(Integer parentId);
}

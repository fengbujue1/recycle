package com.zhouyunji.dao;

import com.zhouyunji.bean.address.Location;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LocationDao {
    List<Location> getLocationsByParentId(Integer parentId);
}

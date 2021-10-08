package com.zhouyunji.service;

import com.zhouyunji.bean.Location;
import com.zhouyunji.dao.LocationDao;
import com.zhouyunji.util.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationService {
    @Autowired
    LocationDao locationDao;

    public Map getLocationMaps() {
        Map<Location, Object> locationMap = LocationUtils.getLocationMap();
        if (locationMap == null) {
            locationMap = new HashMap<>();
            List<Location> locationsByParentId = locationDao.getLocationsByParentId(0);
            if (locationsByParentId != null && locationsByParentId.size() > 0) {
                for (Location location : locationsByParentId) {
                    locationMap.put(location, createLocationMapByParentId(location.getId()));
                }
            }

        }
        return locationMap;
    }
    private Object createLocationMapByParentId(Integer parentId) {
        HashMap<Location, Object> subLocationMap = new HashMap<>();
        List<Location> locationsByParentId = locationDao.getLocationsByParentId(parentId);
        if (locationsByParentId != null && locationsByParentId.size() > 0) {
            for (Location location : locationsByParentId) {
                subLocationMap.put(location, createLocationMapByParentId(location.getId()));
            }
        }
        return null;

    }
}

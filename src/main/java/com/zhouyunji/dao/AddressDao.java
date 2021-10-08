package com.zhouyunji.dao;

import com.zhouyunji.bean.Address;
import com.zhouyunji.bean.FormData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressDao {
    void insertAddress(Address Address);
    List<Address> getAllAddress(int userId);
    void updateAddress(Address address);
}
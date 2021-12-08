package com.zhouyunji.dao;

import com.zhouyunji.bean.address.AddressPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressDao {
    void insertAddress(AddressPo Address);
    List<AddressPo> getAllAddress(String openid);
    void updateAddress(AddressPo address);
    void deleteAddress(Integer id);

    String getAddressStrById(Integer id);
}

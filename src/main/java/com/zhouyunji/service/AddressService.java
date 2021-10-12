package com.zhouyunji.service;

import com.zhouyunji.bean.Address;
import com.zhouyunji.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressDao addressDao;

    @Transactional
    public void addAddress(Address address) {
        if (address.isDefault()) {
            List<Address> allAddress = addressDao.getAllAddress(address.getUserId());
            for (Address address1 : allAddress) {
                if (address1.isDefault()) {
                    Address updateAddress = new Address();
                    updateAddress.setDefault(false);
                    updateAddress.setUserId(address1.getUserId());
                    addressDao.updateAddress(updateAddress);
                }
            }
        }
        addressDao.insertAddress(address);
    }
    @Transactional
    public List<Address> queryAddresses(Integer userId) {
        return addressDao.getAllAddress(userId);

    }
    @Transactional
    public void deleteAddress(Integer id) {
        addressDao.deleteAddress(id);

    }
}

package com.zhouyunji.service;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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
                    updateAddress.setIsDefault(false);
                    updateAddress.setId(address1.getId());
                    addressDao.updateAddress(updateAddress);
                }
            }
        }
        addressDao.insertAddress(address);
    }
    public List<Address> queryAddresses(Integer userId) {
        return addressDao.getAllAddress(userId);

    }
    public void deleteAddress(Integer id) {
        addressDao.deleteAddress(id);
    }
    public void updateAddress(Address address) {
        if (address.isDefault()) {
            List<Address> allAddress = addressDao.getAllAddress(address.getUserId());
            for (Address address1 : allAddress) {
                if (address1.isDefault()) {
                    Address updateAddress = new Address();
                    updateAddress.setIsDefault(false);
                    updateAddress.setId(address1.getId());
                    addressDao.updateAddress(updateAddress);
                }
            }
        }
        addressDao.updateAddress(address);
    }
}

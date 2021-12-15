package com.zhouyunji.service;

import com.zhouyunji.bean.address.Address;
import com.zhouyunji.bean.address.AddressPo;
import com.zhouyunji.dao.AddressDao;
import com.zhouyunji.util.BeanCopyUtil;
import com.zhouyunji.util.TokenUtil;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {
    @Autowired
    AddressDao addressDao;

    private HashMap<String, String> districtCodeMap = new HashMap<>();

    private HashMap<String, String> townCodeMap = new HashMap<>();

    public AddressService() {
        districtCodeMap.put("510183","邛崃市");
        townCodeMap.put("510183001", "文君街道");
        townCodeMap.put("510183002", "临邛街道");
        townCodeMap.put("510183101", "羊安镇");
        townCodeMap.put("510183102", "牟礼镇");
        townCodeMap.put("510183103", "桑园镇");
        townCodeMap.put("510183104", "平乐镇");
        townCodeMap.put("510183105", "夹关镇");
        townCodeMap.put("510183106", "火井镇");
        townCodeMap.put("510183107", "水口镇");
        townCodeMap.put("510183108", "固驿镇");
        townCodeMap.put("510183109", "冉义镇");
        townCodeMap.put("510183110", "回龙镇");
        townCodeMap.put("510183111", "高埂镇");
        townCodeMap.put("510183112", "前进镇");
        townCodeMap.put("510183113", "高何镇");
        townCodeMap.put("510183115", "临济镇");
        townCodeMap.put("510183116", "卧龙镇");
        townCodeMap.put("510183118", "天台山镇");
        townCodeMap.put("510183120", "宝林镇");
        townCodeMap.put("510183201", "茶园乡");
        townCodeMap.put("510183206", "道佐乡");
        townCodeMap.put("510183212", "大同乡");
        townCodeMap.put("510183214", "孔明乡");
    }

    @Transactional
    public void addAddress(Address address) throws Exception {
        String token = address.getToken();
        String openid = TokenUtil.analysisToken(token);
        address.setOpenid(openid);
        if (address.isDefault()) {
            List<AddressPo> allAddress = addressDao.getAllAddress(openid);
            for (AddressPo address1 : allAddress) {
                if (address1.isDefault()) {
                    AddressPo updateAddress = new AddressPo();
                    updateAddress.setDefault(false);
                    updateAddress.setId(address1.getId());
                    addressDao.updateAddress(updateAddress);
                }
            }
        }
        AddressPo addressPo = new AddressPo();
        BeanCopyUtil.copyProperties(address, addressPo, null);
        addressDao.insertAddress(addressPo);
    }
    public List<Address> queryAddresses(String openid) {
        ArrayList<Address> addresses = new ArrayList<>();
        List<AddressPo> allAddress = addressDao.getAllAddress(openid);
        for (AddressPo addressPo : allAddress) {
            Address address = new Address();
            BeanCopyUtil.copyProperties(addressPo, address, null);
            transCodeToNamen(address);
            addresses.add(address);
        }
        return addresses;

    }
    public void deleteAddress(Integer id) {
        addressDao.deleteAddress(id);
    }
    public void updateAddress(Address address) throws Exception {
        String token = address.getToken();
        String openid = TokenUtil.analysisToken(token);
        address.setOpenid(openid);
        if (address.isDefault()) {
            List<AddressPo> allAddress = addressDao.getAllAddress(address.getOpenid());
            for (AddressPo address1 : allAddress) {
                if (address1.isDefault()) {
                    AddressPo updateAddress = new AddressPo();
                    updateAddress.setDefault(false);
                    updateAddress.setId(address1.getId());
                    addressDao.updateAddress(updateAddress);
                }
            }
        }
        AddressPo addressPo = new AddressPo();
        BeanCopyUtil.copyProperties(address, addressPo, null);
        addressDao.updateAddress(addressPo);
    }

    private void transCodeToNamen(Address address) {
        address.setDistrictName(districtCodeMap.get(address.getDistrictCode()));
        address.setTownName(townCodeMap.get(address.getTown()));
    }
}

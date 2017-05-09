package com.wuliangit.shopos.dao;

import com.wuliangit.shopos.common.dao.BaseMapper;
import com.wuliangit.shopos.dto.ApiAddressListDTO;
import com.wuliangit.shopos.entity.Address;

import java.util.ArrayList;

public interface AddressMapper extends BaseMapper<Address, Integer> {

    /**
     * 获取用户地址列表
     * @param memberId
     * @return
     */
    ArrayList<ApiAddressListDTO> getMemberAddressList(Integer memberId);

    /**
     * 清空默认收货地址
     * @param memberId
     * @return
     */
    int cleanDefaultAddress(Integer memberId);

    /**
     * 获取默认收货地址
     * @param memberId
     * @return
     */
    Address getDefaultAddress(Integer memberId);

}
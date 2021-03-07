package com.generator.demo.dao;

import com.generator.demo.entity.HotelAccessPermissionDeviceRela;

public interface HotelAccessPermissionDeviceRelaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelAccessPermissionDeviceRela record);

    int insertSelective(HotelAccessPermissionDeviceRela record);

    HotelAccessPermissionDeviceRela selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelAccessPermissionDeviceRela record);

    int updateByPrimaryKey(HotelAccessPermissionDeviceRela record);
}
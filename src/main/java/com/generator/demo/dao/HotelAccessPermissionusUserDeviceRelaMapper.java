package com.generator.demo.dao;

import com.generator.demo.entity.HotelAccessPermissionusUserDeviceRela;

public interface HotelAccessPermissionusUserDeviceRelaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelAccessPermissionusUserDeviceRela record);

    int insertSelective(HotelAccessPermissionusUserDeviceRela record);

    HotelAccessPermissionusUserDeviceRela selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelAccessPermissionusUserDeviceRela record);

    int updateByPrimaryKey(HotelAccessPermissionusUserDeviceRela record);
}
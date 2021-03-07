package com.generator.demo.dao;

import com.generator.demo.entity.HotelAccessPermissionUserRela;

public interface HotelAccessPermissionUserRelaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelAccessPermissionUserRela record);

    int insertSelective(HotelAccessPermissionUserRela record);

    HotelAccessPermissionUserRela selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelAccessPermissionUserRela record);

    int updateByPrimaryKey(HotelAccessPermissionUserRela record);
}
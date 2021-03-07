package com.generator.demo.dao;

import com.generator.demo.entity.HotelAccessPermission;

public interface HotelAccessPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelAccessPermission record);

    int insertSelective(HotelAccessPermission record);

    HotelAccessPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelAccessPermission record);

    int updateByPrimaryKey(HotelAccessPermission record);
}
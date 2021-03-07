package com.generator.demo.dao;

import com.generator.demo.entity.HotelAccessUserExtra;

public interface HotelAccessUserExtraMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelAccessUserExtra record);

    int insertSelective(HotelAccessUserExtra record);

    HotelAccessUserExtra selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelAccessUserExtra record);

    int updateByPrimaryKey(HotelAccessUserExtra record);
}
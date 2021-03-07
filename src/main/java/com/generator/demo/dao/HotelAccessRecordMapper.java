package com.generator.demo.dao;

import com.generator.demo.entity.HotelAccessRecord;

public interface HotelAccessRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelAccessRecord record);

    int insertSelective(HotelAccessRecord record);

    HotelAccessRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelAccessRecord record);

    int updateByPrimaryKey(HotelAccessRecord record);
}
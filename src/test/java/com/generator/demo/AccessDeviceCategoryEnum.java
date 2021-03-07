package com.generator.demo;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通行设备品类
 *
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/24
 */
@Getter
public enum AccessDeviceCategoryEnum {

    ZNMJ("znmj", "智能门禁"),
    hotelms("hotelms", "酒店门锁");

    private String code;
    private String name;


    AccessDeviceCategoryEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }


    public static List<String> getList() {
        return Arrays.stream(AccessDeviceCategoryEnum.values()).map(categoryEnum -> categoryEnum.getCode()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(AccessDeviceCategoryEnum.getList());
    }


}


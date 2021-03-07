package com.yven.domains;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/25
 */
@Slf4j
public class Main {

    @Test
    public void testCopy1() {
        System.out.println("testCopy1");

        BeanCopier beanCopier = BeanCopier.create(AccessDeviceConditionModel.class, AccessDeviceConditionReq.class, false);
        AccessDeviceConditionReq accessDeviceConditionReq = new AccessDeviceConditionReq();
        beanCopier.copy(this.buildAccessDeviceConditionModel(), accessDeviceConditionReq, null);


        System.out.println(accessDeviceConditionReq);
    }

    @Test
    public void testCopy2() {
        System.out.println("testCopy2");

        List<AccessDeviceConditionModel> accessDeviceConditionModelList = new ArrayList<>();
        accessDeviceConditionModelList.add(this.buildAccessDeviceConditionModel());
        AccessDeviceModelPage accessDeviceModelPage = AccessDeviceModelPage.builder()
                .pageNo(1)
                .pageSize(10)
                .total(100)
                .accessDeviceConditionModelList(accessDeviceConditionModelList)
                .build();

        log.info("accessDeviceModelPage: {}", JSON.toJSONString(accessDeviceModelPage));


        AccessDeviceReqPage accessDeviceReqPage = AccessDeviceReqPage.builder()
                .pageNo(accessDeviceModelPage.getPageNo())
                .pageSize(accessDeviceModelPage.getPageSize())
                .total(accessDeviceModelPage.getTotal())
                .accessDeviceConditionReqList(accessDeviceModelPage.getAccessDeviceConditionModelList().stream().map(
                        accessDeviceConditionModel -> {
                            BeanCopier beanCopier =
                                    BeanCopier.create(AccessDeviceConditionModel.class, AccessDeviceConditionReq.class, false);
                            AccessDeviceConditionReq accessDeviceConditionReq = new AccessDeviceConditionReq();
                            beanCopier.copy(this.buildAccessDeviceConditionModel(), accessDeviceConditionReq, null);
                            return accessDeviceConditionReq;
                        }
                ).collect(Collectors.toList())).build();


        log.info("accessDeviceReqPage: {}", JSON.toJSONString(accessDeviceReqPage));

    }


    private AccessDeviceConditionModel buildAccessDeviceConditionModel() {
        // 获取hotelId
        ArrayList<Long> hotelIds = new ArrayList<>();
        Collections.addAll(hotelIds, 123L);

        // 设备ID
        ArrayList<String> deviceIds = new ArrayList<>();
        Collections.addAll(deviceIds, "9465fsg");


        // 通行设备品类
        List<String> categoryList = new ArrayList<>();
        categoryList.add("hotelms");


        // 通行区域
        List<String> areaTypeList = new ArrayList<>();
        areaTypeList.add("lcgq");


        AccessDeviceConditionModel deviceConditionModel = AccessDeviceConditionModel.builder()
                .hotelIds(hotelIds)
                .deviceIds(deviceIds)
                .categories(categoryList)
                .roomNo("1001")
                .spaceTypes(areaTypeList)
                .permissionStatus(1)
                .pageNo(1)
                .pageSize(10)
                .build();
        return deviceConditionModel;

    }
}

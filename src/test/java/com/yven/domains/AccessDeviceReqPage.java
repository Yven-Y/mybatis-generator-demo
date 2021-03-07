package com.yven.domains;

import lombok.*;

import java.util.List;

/**
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/25
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@ToString
public class AccessDeviceReqPage {

    private Integer pageNo;
    private Integer pageSize;

    private Integer total;

    private List<AccessDeviceConditionReq> accessDeviceConditionReqList;


}

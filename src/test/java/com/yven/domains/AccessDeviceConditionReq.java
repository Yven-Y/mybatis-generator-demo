package com.yven.domains;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/24
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@ToString
public class AccessDeviceConditionReq implements Serializable {


    private static final long serialVersionUID = 8266798455195762698L;

    private List<Long> hotelIds;

    private List<String> deviceIds;

    /**
     * 通行设备：如门锁、门禁
     */
    private List<String> categories;

    private String roomNo;

    /**
     * 通行区域：公区
     */
    private List<String> spaceTypes;

    /**
     * 通行权限状态
     * <p>
     * 1:启用，0:禁用
     *
     *
     */
    private Integer permissionStatus;

    /**
     * 通行权限操作状态
     * <p>
     * -1：无操作状态
     * 2：启动中
     * 3：禁用中
     *
     */
    private Integer permissionOperateStatus;

    @Builder.Default
    private Integer pageNo = 1;

    @Builder.Default
    private Integer pageSize = 10;


}

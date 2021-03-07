package access.demo;


/**
 * 通行类型 enum类
 *
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/18
 */
public enum AccessTypeEnum {
    FACE_ACCESS(1, "人脸通行"),
    CARD_ACCESS(2, "卡片通行"),

    ;

    private Integer code;
    private String name;

    AccessTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }
}


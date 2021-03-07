package access.demo;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

public enum AccessCardOperateTypeEnum {

    /**
     * 卡操作
     */
    DELETED_CARD(0, "删除卡"),
    MODIFY_CARD(1, "修改卡"),
    FREEZE_CARD(2, "冻结卡"),
    UNFREEZE_CARD(3, "解冻卡"),
    OTHER(-1, "其他");

    AccessCardOperateTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AccessCardOperateTypeEnum getCardOperateTypeEnum(Integer code) {
        return Arrays.stream(AccessCardOperateTypeEnum.values()).filter(e -> Objects.equals(code, e.getCode())).findFirst()
                .orElse(AccessCardOperateTypeEnum.OTHER);
    }

    @Getter
    private final Integer code;

    @Getter
    private final String desc;
}

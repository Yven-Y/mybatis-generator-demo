package access.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/03/01
 */

@Slf4j
public class TestEnum {

    public static void main(String[] args) {
        switch (AccessCardOperateTypeEnum.getCardOperateTypeEnum(-1)) {
            case FREEZE_CARD:
                //todo
//                this.batchFreezeCard()
                log.info("FREEZE_CARD");
                break;
            case UNFREEZE_CARD:
                //todo
                log.info("UNFREEZE_CARD");
                break;
            case DELETED_CARD:
                //todo
                log.info("DELETED_CARD");
                break;
            case MODIFY_CARD:
                //todo
                log.info("MODIFY_CARD");
                break;
            default:
                log.warn("操作类型错误");
                break;
        }

        String name = "java";
        Integer id =222;

        log.info("name {}, id: {} 结果",name,id);


        Map<String, Object> paramMap = new HashMap<>(4);
        log.info("paramMap.size():{}", paramMap.size());
        log.info("paramMap.isEmpty():{}", paramMap.isEmpty());


        for (int i = 0; i < 10; i++) {
            System.out.println(toBinary(i,5));
        }
    }

    public static String toBinary(int num, int digits) {
        String cover = Integer.toBinaryString(1 << digits).substring(1);
        String s = Integer.toBinaryString(num);
        return s.length() < digits ? cover.substring(s.length()) + s : s;
    }
}

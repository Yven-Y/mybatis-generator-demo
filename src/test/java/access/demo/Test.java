package access.demo;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/26
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person p1 = Person.builder().id(1).name("111").build();
        Person p2 = Person.builder().id(2).name("222").build();
        Person p3 = Person.builder().id(3).name("333").build();

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        log.info("remove before: {}",JSON.toJSONString(personList));
        List<Person> otherList = getOtherList(personList);
        log.info(" otherList : {}",JSON.toJSONString(otherList));
        personList.removeAll(otherList);
        log.info("remove after: {}",JSON.toJSONString(personList));


    }

    private static List<Person> getOtherList(List<Person> personList){
        List<Person> otherList = new ArrayList<>();
        Person person = personList.get(0);
        otherList.add(person);
        return otherList;
    }

}



@Data
@Builder
class Person{
    private Integer id;
    private String name;
}

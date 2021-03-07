package com.generator.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shaolong.yang@tuya.com
 * @version 1.0
 * @date 2021/02/20
 */
public class Main {


    public static void main(String[] args) {

        Test test = new Test();
        test.test();
    }

    static class Test {
        public Test() {
        }

        public void test() {
            Person person = Person.builder().id("123").build();
            List<CategoryInfo> categoryInfoList = person.getCategoryInfoList();

            List<Person> personList = Optional.ofNullable(categoryInfoList)
                    .map(p -> p.stream().map(x -> {
                        System.out.println(p);
                        return new Person();
                    }).collect(Collectors.toList()))
                    .orElse(Collections.emptyList());


            System.out.println(personList);

        }
    }


}

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@ToString
class Person {
    private String id;
    private String name;

    @Builder.Default
    private Integer pageNO = 1;

    private List<CategoryInfo> categoryInfoList;
}


@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@ToString
class CategoryInfo {
    private String category;
    private String categoryCode;
    private String categoryName;
}

package com.zhouyunji.bean.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author 周赟吉
 * @Date 2023/9/18 13:48
 * @Description :
 */
@Component
public class Test {
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private String age;

    public Test() {
        System.out.println("invoke controust");
    }

    @PostConstruct
    public void con() {
        System.out.println("name:" + name + "   age" + age);
    }
}

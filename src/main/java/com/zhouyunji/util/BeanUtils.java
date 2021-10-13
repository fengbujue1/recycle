package com.zhouyunji.util;

public class BeanUtils {
    public static Object cp(Object src, Class target) {
        try {
            return target.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

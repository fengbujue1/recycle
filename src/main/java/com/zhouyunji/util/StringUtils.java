package com.zhouyunji.util;

public class StringUtils {
    public static boolean isBlank(String s) {
        if (s == null) {
            return true;
        }
        if (s.trim() == "") {
            return true;
        }
        return false;
    }
}

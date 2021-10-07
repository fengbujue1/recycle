package com.zhouyunji.util;


public class PathUtil {
    public static String getClassPath() {
        return PathUtil.class.getResource("/").getPath();
    }
}

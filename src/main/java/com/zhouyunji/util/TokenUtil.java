package com.zhouyunji.util;

public class TokenUtil {
    /**
     * 解析token获取用户openId
     *
     * @return
     */
    public static String analysisToken(String token) {
        if (StringUtils.isBlank(token)) {
            return "";
        }
        return token.substring(0, token.length() - 1);
    }
}

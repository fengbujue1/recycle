package com.zhouyunji.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: server
 * @description: 反射复制
 * @author: guo xu
 * @create: 2019-08-21 09:52
 */
public class BeanCopyUtil {


    private BeanCopyUtil() {

    }


    /***
     * @Description: 数据复制-反射
     * @Author: guoxu
     * @Date: 2019/12/21
     * @param src    源对象
     * @param tar    目标对象
     * @param prefix 属性前缀：默认为""
     */
    public static void copyProperties(Object src, Object tar, String prefix) {
        //为了让assertion生效，你需要在启动Java时启用它们，通常是通过添加-ea或-enableassertions选项到命令行。
        //在生产环境中，断言通常被禁用，因为它们可能会影响性能。断言主要用于开发和测试阶段，用于捕获那些“这不应该发生”的情况。
        assert src == null : "src is null";
        assert tar == null : "tar is null";
        String p = prefix == null ? "" : prefix;
        Class srcClazz = src.getClass();
        Set<String> srcFieldSet = getFieldNameSet(srcClazz);
        Field[] fields = tar.getClass().getDeclaredFields();
        Field.setAccessible(fields, true);
        for (int i = 0; i < fields.length; ++i) {
            Field f = fields[i];
            if (Modifier.isFinal(f.getModifiers())) {
                continue;
            }
            String fname = getTargetFieldName(p, f.getName());
            if (!srcFieldSet.contains(fname)) {
                continue;
            }
            try {
                Field field = srcClazz.getDeclaredField(fname);
                field.setAccessible(true);
                f.set(tar, field.get(src));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /*** 
     * @Description: 返回目标字段名称
     * @Author: guoxu
     * @Date: 2019/12/21
     */
    private static String getTargetFieldName(String prefix, String srcFieldName) {
        if (prefix.isEmpty() || prefix.trim().isEmpty()) {
            return srcFieldName;
        }
        StringBuilder sb = new StringBuilder(prefix);
        sb.append(Character.toUpperCase(srcFieldName.charAt(0))).append(srcFieldName.substring(1));
        return sb.toString();
    }

    /*** 
     * @Description: 获得属性set
     * @Author: guoxu
     * @Date: 2019/12/21
     */
    private static Set<String> getFieldNameSet(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Set<String> set = new HashSet<String>(fields.length);
        for (Field f : fields) {
            if (Modifier.isFinal(f.getModifiers())) {
                continue;
            }
            set.add(f.getName());
        }
        return set;
    }
}

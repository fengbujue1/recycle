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

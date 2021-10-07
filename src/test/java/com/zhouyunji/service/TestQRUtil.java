package com.zhouyunji.service;

import com.zhouyunji.util.QRUtil;

public class TestQRUtil {
    public static void main(String[] args) throws Exception{
        QRUtil.encode("http://localhost:8080/QR/getData?fileName=hello.jpg", "F:\\idea_project\\QR\\QR\\src\\main\\resources\\targetPic\\hello.jpg");
//        QRUtil.encode("我们前边唠叨InnoDB记录行格式的时候重点强调过：\n聚簇索引的记录除了会保存完整的用户数据以外，\n而且还会自动添加名为trx_id、roll_pointer的隐藏列，\n如果用户没有在表中定义主键以及UNIQUE键，\n还会自动添加一个名为row_id的隐藏列。\n所以一条记录在页面中的真实结构看起来就是这样的：", "C:\\Users\\Administrator\\Desktop\\zyj\\testproject\\QRCode\\src\\main\\resources/targetPic/str.jpg");

    }
}

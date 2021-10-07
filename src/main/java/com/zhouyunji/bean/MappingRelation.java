package com.zhouyunji.bean;

public class MappingRelation {
    private String QRLocation;//二维码存储地址
    private String userId;//用户唯一id
    private String fileName;//文件名

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getQRLocation() {
        return QRLocation;
    }

    public void setQRLocation(String QRLocation) {
        this.QRLocation = QRLocation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

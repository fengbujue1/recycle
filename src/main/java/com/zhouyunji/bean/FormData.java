package com.zhouyunji.bean;

public class FormData {
    private String client;//委托单位
    private String userId;//只是用于校验，数据库不存库
    private String fileName;//文件名，展示数据
    private String number;//报告编号
    private String projectName;//试验项目
    private String date;//签发时间
    private String auditPerson;//审批人
    private String result;//检测结果
    private String extraText;//额外信息


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExtraText() {
        return extraText;
    }

    public void setExtraText(String extraText) {
        this.extraText = extraText;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getClient() {
        return client;
    }

    public String getNumber() {
        return number;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDate() {
        return date;
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "client='" + client + '\'' +
                ", number='" + number + '\'' +
                ", projectName='" + projectName + '\'' +
                ", date='" + date + '\'' +
                ", auditPerson='" + auditPerson + '\'' +
                ", result='" + result + '\'' +
                ", extraText='" + extraText + '\'' +
                '}';
    }
}

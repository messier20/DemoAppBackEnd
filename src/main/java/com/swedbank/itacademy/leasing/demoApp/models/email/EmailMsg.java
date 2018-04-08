package com.swedbank.itacademy.leasing.demoApp.models.email;

public class EmailMsg {
    private String toEmail;
    private String subject;
    private String msg;
    private String userName;
    private String id;

    public EmailMsg(String toEmail, String subject, String msg) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.msg = msg;
    }

    public EmailMsg(String toEmail, String subject, String msg, String userName) {
        this(toEmail, subject, msg);
        this.userName = userName;
    }

    public EmailMsg(String toEmail, String subject, String msg, String userName, String id) {
        this(toEmail, subject, msg, userName);
        this.id = id;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package com.example.demo.modules.spider.entity;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
public class LoginLog {
    private Integer logId;
    private Integer userId;
    private String LoginTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(String loginTime) {
        LoginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "logId=" + logId +
                ", userId=" + userId +
                ", LoginTime='" + LoginTime + '\'' +
                '}';
    }
}

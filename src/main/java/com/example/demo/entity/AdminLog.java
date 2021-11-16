package com.example.demo.entity;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
public class AdminLog {

    private Integer logId;
    private Integer adminId;
    private String LoginTime;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(String loginTime) {
        LoginTime = loginTime;
    }

    @Override
    public String toString() {
        return "AdminLog{" +
                "logId=" + logId +
                ", adminId=" + adminId +
                ", LoginTime='" + LoginTime + '\'' +
                '}';
    }
}

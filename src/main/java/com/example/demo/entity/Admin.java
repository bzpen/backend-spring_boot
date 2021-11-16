package com.example.demo.entity;


/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
public class Admin {

    private int admin_id;
    private String admin_name;
    private String admin_number;
    private String admin_pass;
    private String admin_head;
    private int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_number() {
        return admin_number;
    }

    public void setAdmin_number(String admin_number) {
        this.admin_number = admin_number;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getAdmin_head() {
        return admin_head;
    }

    public void setAdmin_head(String admin_head) {
        this.admin_head = admin_head;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_number='" + admin_number + '\'' +
                ", admin_pass='" + admin_pass + '\'' +
                ", admin_head='" + admin_head + '\'' +
                ", role=" + role +
                '}';
    }
}

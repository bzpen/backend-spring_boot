package com.example.demo.entity;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
public class Role {

    private Integer roleId;
    private String type;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", type='" + type + '\'' +
                '}';
    }
}

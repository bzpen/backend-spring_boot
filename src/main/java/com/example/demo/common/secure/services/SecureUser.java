package com.example.demo.common.secure.services;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.demo.common.web.base.domain.BaseDomain;
import com.example.demo.modules.sys.entity.TbRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 基础 UserInfo 实体，为安全验证提供支持的公共属性
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SecureUser extends BaseDomain implements UserDetails,CredentialsContainer {

    /**
     * 用户编号
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 启用
     */
    @TableField(value = "enable")
    private Boolean enable;

    /**
     * 锁定
     */
    @TableField(value = "locked")
    private Boolean locked;

    /**
     * 头像
     */
    @TableField("userPhoto")
    private String userPhoto;

    /**
     * 角色
     */
    @TableField(exist = false)
    private TbRole role;

    /**
     * 最近登录时间
     */
    @TableField("upLoginTime")
    private String upLoginTime;

    /**
     * 注册时间
     */
    @TableField("registTime")
    private String registTime;

    /**
     * 用户邮箱
     */
    @TableField(exist = false)
    private String email;
    /**
     * 权限
     */
    @TableField(exist = false)
    private Set<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

}

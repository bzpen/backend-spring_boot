package com.example.demo.modules.spider.entity;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/15
 */
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@TableName("tb_user")
public class User {

    @ApiModelProperty("用户编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名")
    @TableField(value = "username")
    private String username;

    @ApiModelProperty("用户邮箱")
    @TableField(value = "email")
    private String email;

    @ApiModelProperty("密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty("用户角色")
    @TableField(value = "roleId")
    private Integer roleId;

    @ApiModelProperty("用户最近登录时间")
    @TableField(value = "upLoginTime")
    private Date upLoginTime;

    @ApiModelProperty("用户注册时间")
    @TableField(value = "registTime")
    private String registTime;

    @ApiModelProperty("用户头头像")
    @TableField(value = "userPhoto")
    private String userPhoto;

    @ApiModelProperty("启用")
    @TableField(value = "enable")
    private Boolean enable;

    @ApiModelProperty("锁定")
    @TableField(value = "locked")
    private Boolean locked;

    @ApiModelProperty("逻辑删除")
    @TableField(value = "deleted")
    private Boolean deleted;


}

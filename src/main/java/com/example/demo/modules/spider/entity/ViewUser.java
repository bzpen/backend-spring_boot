package com.example.demo.modules.spider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
@Getter
@Setter
@TableName("view_user")
@ApiModel(value = "ViewUser对象", description = "VIEW")
public class ViewUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户编号")
    @TableField("id")
    private Integer id;

    @ApiModelProperty("账号")
    @TableField("username")
    private String username;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("最近登录时间")
    @TableField("upLoginTime")
    private LocalDateTime upLoginTime;

    @ApiModelProperty("注册时间")
    @TableField("registTime")
    private LocalDateTime registTime;

    @ApiModelProperty("头像")
    @TableField("userPhoto")
    private String userPhoto;

    @ApiModelProperty("权限名")
    @TableField("name")
    private String name;


}

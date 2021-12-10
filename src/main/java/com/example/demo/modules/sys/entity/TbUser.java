package com.example.demo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.demo.common.secure.services.SecureUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-08
 */
@Data
@TableName("tb_user")
@ApiModel(value = "TbUser对象", description = "")
public class TbUser extends SecureUser implements Serializable {

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("角色")
    @TableField("roleId")
    private String roleId;

    @ApiModelProperty("最近登录时间")
    @TableField("upLoginTime")
    private String upLoginTime;

    @ApiModelProperty("注册时间")
    @TableField("registTime")
    private String registTime;

    @ApiModelProperty("头像")
    @TableField("userPhoto")
    private String userPhoto;


}

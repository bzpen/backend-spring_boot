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

    @TableField("userEmail")
    private String userEmail;

    @TableField("roleId")
    private String roleId;

    @TableField("upLoginTime")
    private LocalDateTime upLoginTime;

    @TableField("registTime")
    private LocalDateTime registTime;

    @TableField("userPhoto")
    private String userPhoto;


}

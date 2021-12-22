package com.example.demo.modules.spider.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

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
@TableName("view_admin")
@ApiModel(value = "ViewAdmin对象", description = "VIEW")
public class ViewAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelProperty("管理员编号")
    @TableField("id")
    private Integer id;

    @ExcelProperty("管理员姓名")
    @TableField("name")
    private String name;

    @ExcelProperty("管理员账号")
    @TableField("username")
    private String username;

    @ExcelIgnore
    @TableField("userPhoto")
    private String userPhoto;

    @ExcelIgnore
    @TableField("enable")
    private Boolean enable;

    @ExcelIgnore
    @TableField("locked")
    private Boolean locked;

    @ExcelProperty("管理员权限")
    @ApiModelProperty("权限名")
    @TableField("roidName")
    private String roidName;

    @ExcelProperty("最近登录时间")
    @ApiModelProperty("用户最近登录时间")
    @TableField(value = "upLoginTime")
    private String upLoginTime;

    @ExcelProperty("注册时间")
    @ApiModelProperty("用户注册时间")
    @TableField(value = "registTime")
    private String registTime;

}

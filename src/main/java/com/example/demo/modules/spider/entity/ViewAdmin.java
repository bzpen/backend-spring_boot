package com.example.demo.modules.spider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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

    @TableField("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("number")
    private String number;

    @TableField("head")
    private String head;

    @TableField("enable")
    private Boolean enable;

    @TableField("locked")
    private Boolean locked;

    @ApiModelProperty("权限名")
    @TableField("roidName")
    private String roidName;


}

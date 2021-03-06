package com.example.demo.modules.spider.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Data
@Builder
@TableName("tb_admin")
@ApiModel(value = "TbAdmin对象", description = "")
public class TbAdmin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("userPhoto")
    private String userPhoto;

    @TableField("roleId")
    private Integer roleId;

    @TableField("enable")
    private Boolean enable;

    @TableField("locked")
    private Boolean locked;

    @TableField("deleted")
    private Boolean deleted;


}

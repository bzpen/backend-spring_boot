package com.example.demo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.common.secure.services.SecureUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 管 理 员 登 录 实 体 类
 *
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/20
 */
@Data
@TableName("tb_user")
@ApiModel(value = "TbUser对象", description = "")
@EqualsAndHashCode(callSuper = true)
public class SysAdmin extends SecureUser implements Serializable {

    @ApiModelProperty("名字")
    @TableField("name")
    private String name;

    @ApiModelProperty("角色")
    @TableField("roleId")
    private String roleId;
}

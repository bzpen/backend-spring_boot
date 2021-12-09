package com.example.demo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Getter
@Setter
@TableName("tb_role")
@ApiModel(value = "TbRole对象", description = "")
public class TbRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("权限编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("权限名")
    @TableField("name")
    private String name;

    @ApiModelProperty("是否启用（1启用0关闭）")
    @TableField("enable")
    private Boolean enable;

    @ApiModelProperty("逻辑删除（1删除0未删除）")
    @TableField("deleted")
    private Boolean deleted;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}

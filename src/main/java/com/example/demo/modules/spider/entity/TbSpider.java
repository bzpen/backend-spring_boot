package com.example.demo.modules.spider.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2021-12-15
 */
@Data
@TableName("tb_spider")
@ApiModel(value = "TbSpider对象", description = "")
public class TbSpider implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("蜘蛛名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("蜘蛛图片")
    @TableField("photoPath")
    private String photoPath;

    @ApiModelProperty("样本数量")
    @TableField("sample")
    private Integer sample;

    @ApiModelProperty("详情介绍")
    @TableField("remark")
    private String remark;


}

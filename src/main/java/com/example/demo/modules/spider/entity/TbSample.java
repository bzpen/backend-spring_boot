package com.example.demo.modules.spider.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("tb_sample")
@ApiModel(value = "TbSample对象", description = "")
public class TbSample implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("样本编号")
    @TableField("number")
    private String number;

    @ApiModelProperty("蜘蛛编号")
    @TableField("spider")
    private Integer spider;

    @ApiModelProperty("上传者用户id")
    @TableField("user")
    private Integer user;

    @ApiModelProperty("基因类型")
    @TableField("genetic")
    private String genetic;

    @ApiModelProperty("采样时间")
    @TableField("time")
    private LocalDateTime time;

    @ApiModelProperty("采样地点")
    @TableField("locations")
    private String locations;

    @ApiModelProperty("采样精度")
    @TableField("j_du")
    private String jDu;

    @ApiModelProperty("采样纬度")
    @TableField("w_du")
    private String wDu;

    @ApiModelProperty("样本序列")
    @TableField("list")
    private String list;

    @ApiModelProperty("序列长度")
    @TableField("length")
    private Integer length;

    @ApiModelProperty("样本介绍")
    @TableField("remark")
    private String remark;


}

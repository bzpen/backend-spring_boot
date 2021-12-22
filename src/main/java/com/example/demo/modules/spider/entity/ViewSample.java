package com.example.demo.modules.spider.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.common.web.base.excel.LocalDateTimeConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
@Data
@TableName("view_sample")
@ApiModel(value = "ViewSample对象", description = "VIEW")
public class ViewSample implements Serializable {

    private static final long serialVersionUID = 1L;

    @ExcelIgnore
    @TableField("id")
    private Integer id;

    @ExcelProperty("样本编号")
    @ApiModelProperty("样本编号")
    @TableField("number")
    private String number;

    @ExcelIgnore
    @ApiModelProperty("蜘蛛编号")
    @TableField("spider")
    private Integer spider;

    @ExcelIgnore
    @ApiModelProperty("上传者用户id")
    @TableField("user")
    private Integer user;

    @ExcelProperty("基因类型")
    @ApiModelProperty("基因类型")
    @TableField("genetic")
    private String genetic;

    @ExcelProperty("种类名称")
    @ApiModelProperty("蜘蛛名称")
    @TableField("name")
    private String name;

    @ExcelProperty(value = "采样时间",converter = LocalDateTimeConverter.class)
    @ApiModelProperty("采样时间")
    @TableField("time")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    @ExcelProperty("采样地点")
    @ApiModelProperty("采样地点")
    @TableField("locations")
    private String locations;

    @ExcelProperty("采样经度")
    @ApiModelProperty("采样经度")
    @TableField("j_du")
    private String jdu;

    @ExcelProperty("采样纬度")
    @ApiModelProperty("采样纬度")
    @TableField("w_du")
    private String wdu;

    @ExcelProperty("样本序列")
    @ApiModelProperty("样本序列")
    @TableField("list")
    private String list;

    @ExcelProperty("样本介绍")
    @ApiModelProperty("样本介绍")
    @TableField("remark")
    private String remark;

    @ExcelProperty("上传者账号")
    @ApiModelProperty("账号")
    @TableField("username")
    private String username;


    @ExcelProperty("批量上传错误信息")
    @ApiModelProperty("批量上传错误信息")
    @TableField(exist = false)
    private String errMessage;


}

package com.example.demo.common.web.base.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * base 实体
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@Data
public class BaseDomain implements Serializable {
    /**
     * 逻辑删除
     */
    @ApiModelProperty("逻辑删除")
    private String deleted;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}

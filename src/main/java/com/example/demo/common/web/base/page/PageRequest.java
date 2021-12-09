package com.example.demo.common.web.base.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页参数
 *
 * @author kaito kuroba
 * @date 2021/12/6
 */
@Data
@ApiModel("分页实体")
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    /**
     *  当前页码
     */
    @ApiModelProperty("当前页码")
    private int pageNum=1;

    /**
     * 每页数量
     */
    @ApiModelProperty("当前页码")
    private int pageSize = 10;
}

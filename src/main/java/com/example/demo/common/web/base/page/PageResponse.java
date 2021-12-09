package com.example.demo.common.web.base.page;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果
 *
 * @author kaito kuroba
 * @date 2021/12/6
 */
@Data
@NoArgsConstructor
public class PageResponse<T> {
    /**
     * 总页数
     */
    private long total;

    /**
     * 分页后的数据
     */
    private List<T> record;

    /**
     * 构建实体
     * @param total
     * @param record
     */
    public PageResponse(int total,List<T> record){
        this.total = total;
        this.record = record;
    }

    /**
     * 构建实体
     * */
    public PageResponse(PageInfo pageInfo){
        this.record = pageInfo.getList();
        this.total = pageInfo.getTotal();
    }
}

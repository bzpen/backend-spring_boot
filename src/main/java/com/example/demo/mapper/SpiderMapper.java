package com.example.demo.mapper;

import com.example.demo.entity.Spider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
@Mapper
public interface SpiderMapper {
    /**
     * 获取单个spider数据
     * @param spider
     * @return
     */
    Spider get(Spider spider);
    /**
     * 获取spider分类列表
     * @return
     */
    List<Spider> gets();

    /**
     * 根据spider名字查询
     * @param spider
     * @return
     */
    List<Spider> get_name(Spider spider);

    /**
     * 更改spider记录
     * @return
     */
    int update(Spider spider);

    /**
     * 插入新记录
     * @param spider
     * @return
     */
    int insert(Spider spider);

    /**
     * 删除一条记录
     * @param spider
     * @return
     */
    int delete(Spider spider);


}

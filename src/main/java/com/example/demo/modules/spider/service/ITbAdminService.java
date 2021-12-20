package com.example.demo.modules.spider.service;

import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbAdmin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
public interface ITbAdminService extends IService<TbAdmin> {

    /**
     * 管 理 员 批 量 删 除
     *
     * @param list
     * @return
     */
    boolean delList(List<Integer> list);
}

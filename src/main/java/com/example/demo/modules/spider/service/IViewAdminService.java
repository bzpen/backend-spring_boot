package com.example.demo.modules.spider.service;

import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.modules.spider.entity.ViewAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.param.PageViewAdminRequest;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
public interface IViewAdminService extends IService<ViewAdmin> {


    /**
     *  管理员序列查询分页实现
     *
     * @param request
     * @return
     */
    PageResponse<ViewAdmin> page(PageViewAdminRequest request);

}

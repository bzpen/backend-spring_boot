package com.example.demo.modules.spider.service;

import com.example.demo.common.web.base.page.PageRequest;
import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.modules.spider.entity.ViewAdmin;
import com.example.demo.modules.spider.entity.ViewUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.modules.spider.param.PageUserRequest;
import com.example.demo.modules.spider.param.PageViewAdminRequest;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
public interface IViewUserService extends IService<ViewUser> {


    /**
     *  用户序列查询分页实现
     *
     * @param request
     * @return
     */
    PageResponse<ViewUser> page(PageUserRequest request);

}

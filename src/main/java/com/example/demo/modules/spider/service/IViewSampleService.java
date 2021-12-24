package com.example.demo.modules.spider.service;

import com.example.demo.common.web.base.page.PageResponse;
import com.example.demo.modules.spider.entity.ViewSample;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.modules.spider.param.PageSampleRequest;

import javax.servlet.http.HttpServletRequest;
    import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-14
 */
public interface IViewSampleService extends IService<ViewSample> {

    /**
     *  基因序列查询分页实现
     *
     * @param request
     * @return
     */
    PageResponse<ViewSample> list(PageSampleRequest request);


    /**
     * 基因序列个人上传列表分页实现
     *
     * @param request
     * @return
     */
    PageResponse<ViewSample> list_user(HttpServletRequest request,PageSampleRequest pageRequest);



    /**
     * 前台筛选实现
     *
     * @param request
     * @return
     */
    PageResponse<ViewSample> screen(PageSampleRequest request);

}

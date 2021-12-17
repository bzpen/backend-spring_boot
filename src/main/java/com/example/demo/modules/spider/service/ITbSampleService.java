package com.example.demo.modules.spider.service;

import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSample;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.param.MapSample;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
public interface ITbSampleService extends IService<TbSample> {

    /**
     * 检测序列编号是否重复
     *
     * @param number
     * @return
     */
    boolean checkNumber(String number);

    /**
     * 序列检测
     *
     * @param list
     * @return
     */
    boolean checkList(String list);

    /**
     * 添 加 新 记 录
     *
     * @param entity
     * @return
     * @throws IOException
     */
    Result add(TbSample entity, HttpServletRequest request) throws IOException;


    /**
     * excel 批量上传数据
     *
     * @param viewSampleList
     * @return
     * @throws Exception
     */
    List<ViewSample> adds(List<ViewSample> viewSampleList,HttpServletRequest request) throws Exception;

    /**
     * 获取地图数据
     *
     * @return
     */
    List<MapSample> getMapList();


}

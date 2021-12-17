package com.example.demo.common.web.base.echarts;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.param.MapSample;
import com.example.demo.modules.spider.service.ITbSampleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/15
 */
@Component
public class ECharsService {

    @Resource
    ITbSampleService iTbSampleService;

    /**
     * 获取 EChars 地图数据
     *
     * @return
     */
    public List<MapECharts> getEChars(){

        List<MapSample> list = iTbSampleService.getMapList();

        List<MapECharts> mapEChartsList=new ArrayList<>();
        for(MapSample tbSample:list){
            QueryWrapper<TbSample> query=new QueryWrapper<>();
            query.eq("j_du",tbSample.getJDu())
                    .eq("w_du",tbSample.getWDu());

            double[] doubles = {Double.parseDouble(tbSample.getJDu()),Double.parseDouble(tbSample.getWDu()),iTbSampleService.count(query)};

            MapECharts mapECharts=MapECharts.builder()
                    .name(tbSample.getLocations())
                    .value(doubles)
                    .label(Label.builder().position("right").build())
                    .symbol("pin")
                    .build();
            mapEChartsList.add(mapECharts);
        }
        return mapEChartsList;
    }

}

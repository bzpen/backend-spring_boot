package com.example.demo.modules.spider.service.Impl;

import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.Sample;
import com.example.demo.modules.spider.mapper.SampleMapper;
import com.example.demo.modules.spider.service.SampleService;
import com.example.demo.common.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
@Service
@Slf4j
public class SampleServiceImpl implements SampleService {
    @Autowired
    SampleMapper sampleMapper;

    @Override
    public Result get(Integer sampleId) {
        try{
            Sample sample = sampleMapper.get(sampleId);
            return Result.success(sample);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure();
    }

    @Override
    public Result gets() {
        try{
            List<Sample> samples = sampleMapper.gets();
            if(!samples.isEmpty()){
                return Result.success(samples);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return Result.failure();
    }

    @Override
    public Result del(Integer sampleId) {
        try{
            int result=sampleMapper.del(sampleId);
            if(result != 0){
                return Result.success("删除数据成功！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("删除数据失败！");
    }

    @Override
    public Result update(Sample sample) {
        try{
            String []s= FileUploadUtil.getCoordinate(sample.getSampleLocations());
            if(s[0].length()<15&&Float.parseFloat(s[1])<30.0){
                sample.setSampleJdu(s[0]);
                sample.setSampleWdu(s[1]);
                sample.setSampleLength(sample.getSampleList().length());
                int result=sampleMapper.update(sample);
                if(result != 0){
                    return Result.success("更新数据成功！");
                }
            }else{
                return Result.failure("经纬度计算失败，请重试（可能是系统原因或者地点名存在歧义）！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("更新数据失败！");
    }

    @Override
    public Result add(Sample sample) throws IOException {
        String []s= FileUploadUtil.getCoordinate(sample.getSampleLocations());
        System.out.println(s[0]+','+s[1]);
        if(s[0].length()<15&&Float.parseFloat(s[1])<30.0){
            sample.setSampleJdu(s[0]);
            sample.setSampleWdu(s[1]);
            sample.setSampleLength(sample.getSampleList().length());
            int result=sampleMapper.add(sample);
            if(result != 0){
                return Result.success("添加数据成功！");
            }
        }else{
            return Result.failure("经纬度计算失败，请重试（可能是系统原因或者地点名存在歧义）！");
        }
        return Result.failure("添加数据失败！");
    }
}

package com.example.demo.service.Impl;

import com.example.demo.core.response.Result;
import com.example.demo.entity.Spider;
import com.example.demo.mapper.SpiderMapper;
import com.example.demo.service.SpiderService;
import com.example.demo.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    @Autowired
    SpiderMapper spiderMapper;

    @Override
    public Result gets() {
        try{
            List<Spider> spiders=spiderMapper.gets();
            if(spiders!=null){
                return Result.success("数据获取成功！",spiders);
            }else{
                return Result.success("数据列表为空！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("数据获取失败！");
    }

    @Override
    public Result get(Spider spider) {
        try{
            Spider result=spiderMapper.get(spider);
            if(result!=null){
                return Result.success("数据获取成功！",result);
            }else{
                return Result.success("数据列表为空！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("数据获取失败！");
    }

    @Override
    public Result insert(Spider spider, MultipartFile file) {
        try{
            int result=spiderMapper.insert(spider);
            if(result != 0){
                return Result.success("插入数据成功！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("插入数据失败！");
    }

    @Override
    public Result update(Spider spider) {
        try{
            int result=spiderMapper.update(spider);
            if(result != 0){
                return Result.success("更新数据成功！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("更新数据失败！");
    }

    @Override
    public Result delete(Spider spider) {
        try{
            int result=spiderMapper.delete(spider);
            if(result != 0){
                return Result.success("删除数据成功！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("删除数据失败！");
    }

    @Override
    public Result deleteList(List<Spider> spiderList) {
        return null;
    }
}

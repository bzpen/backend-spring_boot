package com.example.demo.service.Impl;

import com.example.demo.config.WebMvcConfig;
import com.example.demo.core.response.Result;
import com.example.demo.entity.Spider;
import com.example.demo.entity.SpiderImgPath;
import com.example.demo.mapper.SpiderMapper;
import com.example.demo.service.SpiderService;
import com.example.demo.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/11/16
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    @Autowired
    SpiderMapper spiderMapper;

    private final String REAL_IMG_PATH = WebMvcConfig.REAL_IMG_PATH + "spider_photo/";
    private final String VIRTUAL_IMG_PATH = WebMvcConfig.VIRTUAL_IMG_PATH;

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
            SpiderImgPath spiderImgPath= new SpiderImgPath();
            spiderImgPath.setSpider(spiderMapper.get(spider));
            if(spiderImgPath.getSpider()!=null){
                File img_path= new File(REAL_IMG_PATH + spiderImgPath.getSpider().getSpiderPhoto());
                for(String path:img_path.list()){
                    spiderImgPath.getImg_path().add(VIRTUAL_IMG_PATH + spiderImgPath.getSpider().getSpiderPhoto() +"/"+path);
                }
                return Result.success("数据查询成功！",spiderImgPath);
            }else{
                return Result.success("数据列表为空！");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return Result.failure("数据获取失败！");
    }

    @Override
    public Result insert(Spider spider) {
        String file_path= Long.toString(System.currentTimeMillis());
        try{
            if(spiderMapper.get_name(spider).isEmpty()){
                spider.setSpiderSample(0);
                spider.setSpiderPhoto(file_path);
                int result = spiderMapper.insert(spider);
                if(result == 1 ){
                    return Result.success("插入数据成功！",spider);
                }
            }else{
                return Result.failure("种类名称重复！");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("插入失败请重试！");
    }

    @Override
    public Result insert(MultipartFile file, String file_path) {
        File save = new File(REAL_IMG_PATH + file_path);
        try {
            if (file.isEmpty()) {
                return Result.failure("图片为空，请选择图片！");
            } else {
                save.mkdir();
                String file_Name = file.getOriginalFilename();
                if (file_Name.endsWith("jpg") || file_Name.endsWith("png") || file_Name.endsWith("jpeg")) {
                    file.transferTo(Paths.get(REAL_IMG_PATH + file_path + "/" + file_Name));
                }
                return Result.success();
            }
        } catch (Exception e) {
            Result.success("插入失败！",e);
        }
        return Result.failure();
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

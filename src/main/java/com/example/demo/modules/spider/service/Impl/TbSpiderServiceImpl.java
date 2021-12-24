package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.constant.Constant;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSpider;
import com.example.demo.modules.spider.mapper.TbSpiderMapper;
import com.example.demo.modules.spider.param.SpiderImgPath;
import com.example.demo.modules.spider.service.ITbSpiderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Paths;

import static com.example.demo.common.constant.Constant.Img.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Service
public class TbSpiderServiceImpl extends ServiceImpl<TbSpiderMapper, TbSpider> implements ITbSpiderService {


    /**
     * 查 询 spider 信息
     *
     * @param name
     * @return
     */
    @Override
    public TbSpider getSpider(String name) {
        QueryWrapper<TbSpider> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name).last("limit 1");

        return super.getOne(queryWrapper);
    }

//    @Override
//    public Result add(TbSpider tbSpider) {
//        try{
//            SpiderImgPath spiderImgPath= new SpiderImgPath();
//            spiderImgPath.setSpider(spiderMapper.get(spider));
//            if(spiderImgPath.getSpider()!=null){
//                File img_path= new File(REAL_IMG_PATH + spiderImgPath.getSpider().getSpiderPhoto());
//                for(String path:img_path.list()){
//                    spiderImgPath.getImg_path().add(VIRTUAL_IMG_PATH + spiderImgPath.getSpider().getSpiderPhoto() +"/"+path);
//                }
//                return Result.success("数据查询成功！",spiderImgPath);
//            }else{
//                return Result.success("数据列表为空！");
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return Result.failure("数据获取失败！");
//    }

    @Override
    public Result add(TbSpider spider) {
        String file_path= Long.toString(System.currentTimeMillis());
        System.out.println(this.getSpider(spider.getName()));
        try{
            if(this.getSpider(spider.getName()) != null){
                return Result.failure("种类名称重复！");
            }
            spider.setSample(0);
            spider.setPhotoPath(file_path);
            if(super.save(spider)){
                return Result.success("插入数据成功！",spider);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Result.failure("插入失败请重试！");
    }

    @Override
    public Result add(MultipartFile file, String file_path) {
        File save = new File(REAL_IMG_PATH + IMG_SPIDER + file_path);
        try {
            if (file.isEmpty()) {
                return Result.failure("图片为空，请选择图片！");
            } else {
                save.mkdir();
                String file_Name = file.getOriginalFilename();
                if (file_Name.endsWith("jpg") || file_Name.endsWith("png") || file_Name.endsWith("jpeg")) {
                    file.transferTo(Paths.get(save  + "/" + System.currentTimeMillis() + "." + FilenameUtils.getExtension(file_Name)));
                    return Result.success();
                }
                return Result.failure("图片格式只能为jpg/png/jpeg");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.failure("插入失败！");
    }

    /**
     * 获 取 蜘 蛛 种 类 详 情
     *
     * @param id
     * @return
     */
    @Override
    public SpiderImgPath getSpiderImage(Serializable id) {
        SpiderImgPath spiderImgPath= new SpiderImgPath();

        spiderImgPath.setSpider(super.getById(id));

        if(spiderImgPath.getSpider()!=null){
            File img_path= new File(REAL_IMG_PATH + IMG_SPIDER + spiderImgPath.getSpider().getPhotoPath());
            for(String path:img_path.list()){
                spiderImgPath.getImg_path().add(VIRTUAL_IMG_PATH + IMG_SPIDER + spiderImgPath.getSpider().getPhotoPath() +"/"+path);
            }
        }
        return spiderImgPath;
    }

    /**
     * 删 除 图 片
     *
     * @param filePath
     * @return
     */
    @Override
    public Boolean delImage(String filePath) {
        File save = new File(REAL_IMG_PATH + IMG_SPIDER + filePath);
        save.delete();
        return true;
    }
}
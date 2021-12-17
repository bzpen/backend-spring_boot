package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.constant.Constant;
import com.example.demo.common.secure.services.SecureUser;
import com.example.demo.common.secure.uutoken.SecureUserToken;
import com.example.demo.common.secure.uutoken.SecureUserTokenService;
import com.example.demo.common.web.base.coordinates.Coordinates;
import com.example.demo.common.web.base.coordinates.CoordinatesService;
import com.example.demo.common.web.domain.Result;
import com.example.demo.modules.spider.entity.TbSample;
import com.example.demo.modules.spider.entity.TbSpider;
import com.example.demo.modules.spider.entity.ViewSample;
import com.example.demo.modules.spider.mapper.TbSampleMapper;
import com.example.demo.modules.spider.param.MapSample;
import com.example.demo.modules.spider.service.ITbSampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.modules.spider.service.ITbSpiderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-15
 */
@Service
public class TbSampleServiceImpl extends ServiceImpl<TbSampleMapper, TbSample> implements ITbSampleService {

    @Resource
    TbSampleMapper tbSampleMapper;

    @Resource
    SecureUserTokenService customUserDetailsTokenService;

    @Resource
    ITbSpiderService iTbSpiderService;
    /**
     * 序 列 检 测
     *
     * @param list
     * @return
     */
    @Override
    public boolean checkList(String list) {
        QueryWrapper<TbSample> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("list",list)
                .last("limit 1");

        TbSample sample = super.getOne(queryWrapper);
        if(sample == null)
            return false;
        return true;
    }

    /**
     * 序列编号检测
     *
     * @param number
     * @return
     */
    @Override
    public boolean checkNumber(String number) {
        QueryWrapper<TbSample> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("number",number)
                .last("limit 1");

        TbSample sample = super.getOne(queryWrapper);

        if(sample == null)
            return false;
        return true;
    }

    /**
     * 新 增 蜘 蛛 序 列
     *
     * @param entity
     * @return
     */
    @Override
    public Result add(TbSample entity, HttpServletRequest request) throws IOException {
        Coordinates coordinates = CoordinatesService.getCoordinate(entity.getLocations());
        if(coordinates==null)
            return Result.failure("经纬度无法正确计算，请重试！");
        TbSample tbSample=TbSample.builder()
                .id(null)
                .number(entity.getNumber())
                .spider(entity.getSpider())
                .genetic(entity.getGenetic())
                .locations(entity.getLocations())
                .jDu(coordinates.getJ_du())
                .wDu(coordinates.getW_du())
                .list(entity.getList())
                .length(entity.getList().length())
                .remark(entity.getRemark())
                .time(entity.getTime())
                .user(Integer.parseInt(this.getSecureUser(request).getId()))
                .build();
        super.save(tbSample);
        return Result.success("数据上传成功！");
    }

    /**
     * excel 批量上传数据
     *
     * @param viewSampleList
     * @return
     * @throws Exception
     */
    @Override
    public List<ViewSample> adds(List<ViewSample> viewSampleList,HttpServletRequest request) throws Exception {

        List<ViewSample> failList=new ArrayList<ViewSample>();
        for(ViewSample viewSample : viewSampleList){

            if(this.checkNumber(viewSample.getNumber())){
                viewSample.setErrMessage("样本编号重复，请检查重试！");
                failList.add(viewSample);
                continue;
            }

            viewSample.setUser(Integer.parseInt(this.getSecureUser(request).getId()));

            TbSpider tbSpider= iTbSpiderService.getSpider(viewSample.getName());
            if(tbSpider == null){
                viewSample.setErrMessage("该种类未添加！");
                failList.add(viewSample);
                continue;
            }
            viewSample.setSpider(tbSpider.getId());
//           坐标计算
            Coordinates coordinates = CoordinatesService.getCoordinate(viewSample.getLocations());
            if(coordinates == null){
                viewSample.setErrMessage("经纬度无法正确计算，请重试！");
                failList.add(viewSample);
                continue;
            }
            viewSample.setJDu(coordinates.getJ_du());
            viewSample.setWDu(coordinates.getW_du());

            TbSample tbSample =TbSample.builder()
                    .user(viewSample.getUser())
                    .remark(viewSample.getRemark())
                    .length(viewSample.getList().length())
                    .wDu(viewSample.getWDu())
                    .jDu(viewSample.getJDu())
                    .locations(viewSample.getLocations())
                    .time(viewSample.getTime())
                    .spider(viewSample.getSpider())
                    .genetic(viewSample.getGenetic())
                    .list(viewSample.getList())
                    .id(null)
                    .number(viewSample.getNumber())
                    .build();
            super.save(tbSample);
        }
        return failList;
    }

    /**
     * 解 析 token 获取用户信息
     *
     * @param request
     * @return
     */
    public SecureUser getSecureUser(HttpServletRequest request){

        String tokenHeader = request.getHeader(Constant.Token.TOKEN_HEADER);
        // token verify
        SecureUser secureUser;
        SecureUserToken userToken = customUserDetailsTokenService.verifyToken(tokenHeader);
        secureUser = userToken.getSecureUser();
        return secureUser;
    }

    /**
     * 获 取 地 图 数 据
     *
     * @return
     */
    @Override
    public List<MapSample> getMapList() {
        return tbSampleMapper.getMapList();
    }
}

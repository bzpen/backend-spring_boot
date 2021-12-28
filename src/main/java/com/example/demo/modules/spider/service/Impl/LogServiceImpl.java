package com.example.demo.modules.spider.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.modules.spider.entity.Log;
import com.example.demo.modules.spider.mapper.LogMapper;
import com.example.demo.modules.spider.param.LogList;
import com.example.demo.modules.spider.param.PageSampleRequest;
import com.example.demo.modules.spider.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaito kuroba
 * @since 2021-12-21
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Resource
    LogMapper logMapper;


    @Override
    public boolean save(Log entity) {
        entity.setDate(LocalDateTime.now());
        return super.save(entity);
    }


    public LogList getLogData() {

        Calendar calendar = Calendar.getInstance();
        Date date= new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");//设置当前时间的格式，为年-月-日


        calendar.setTime(date);//把当前时间赋给日历
        calendar.add(Calendar.DAY_OF_MONTH, 2- calendar.get(Calendar.DAY_OF_WEEK));  //设置为前一天
        date = calendar.getTime();   //得到前一天的时间

        PageSampleRequest request=new PageSampleRequest();

        LogList logList = new LogList();
        for(int i=0;i<7;i++){
            request.setStartTime(dateFormat.format(date));
            calendar.setTime(date);//把当前时间赋给日历
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            date = calendar.getTime();
            request.setStopTime(dateFormat.format(date));


            logList.getUser().add(logMapper.getLoginUser(request));

            logList.getAdmin().add(logMapper.getLoginAdmin(request));

        }

        return logList;
    }
}

package com.example.demo.common.secure;

import com.example.demo.modules.spider.mapper.LogMapper;
import com.example.demo.modules.spider.param.LogList;
import com.example.demo.modules.spider.param.PageSampleRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Password Test
 *
 * @author Leo Wang
 * @since 2021/11/30
 */
@SpringBootTest
public class PasswordTest {

    /**
     * 打印加密后密码 - 登陆密码加密
     */
    @Test
    void printPasswordEncoder() {
        String password = "123";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode(password));
    }

    @Resource
    LogMapper logMapper;

    @Test
    void printDate(){
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

    }
}

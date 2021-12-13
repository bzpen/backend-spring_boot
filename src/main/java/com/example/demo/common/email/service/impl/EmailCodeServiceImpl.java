package com.example.demo.common.email.service.impl;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.common.constant.Constant;
import com.example.demo.common.email.entity.Email;
import com.example.demo.common.email.service.EmailCodeService;
import com.example.demo.common.util.EmailCodeUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.exception.token.TokenException;
import com.example.demo.modules.sys.entity.TbUser;
import com.example.demo.modules.sys.service.ITbUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
@Service
public class EmailCodeServiceImpl implements EmailCodeService {

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private ITbUserService iTbUserService;

    @Value("${spring.mail.username}")
    private String from;// 发送者

    @Override
    public void createCode(Email email) {
        email.setCode(EmailCodeUtil.creatCode());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email.getUserEmail());
        message.setSubject(Constant.Email.EMAIL_HEADER);
        message.setText(Constant.Email.EMAIL_FONT + email.getCode() + Constant.Email.EMAIL_REAR);
        System.out.println(email.toString());
        mailSender.send(message);
        this.saveCode(email);
    }

    @Override
    public Email saveCode(Email email) {
        redisTemplate.opsForValue().set(Constant.Email.CODE_NAME_PREFIX+ email.getUserEmail(),email.getCode(),Constant.Security.CODE_EXPIRATION, TimeUnit.SECONDS);
        return email;
    }

    @Override
    public Email verifyCode(String key) throws TokenException {
        return null;
    }

    @Override
    public String taskCode(String key) {
        return redisTemplate.opsForValue().get(Constant.Email.CODE_NAME_PREFIX + key);
    }

    @Override
    public void destroyCode(String key) {
        redisTemplate.delete(Constant.Email.CODE_NAME_PREFIX + key);
    }

    @Override
    public Result check(Email email) {
        UserDetails userDetails = iTbUserService.getByEmail(email.getUserEmail());
        if(userDetails != null){
            return Result.success();
        }
        return Result.failure();
    }
}

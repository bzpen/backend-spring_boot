package com.example.demo.common.email.service.impl;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.email.entity.Email;
import com.example.demo.common.email.service.EmailCodeService;
import com.example.demo.common.util.EmailCodeUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.exception.token.TokenException;
import com.example.demo.modules.sys.service.SysUserService;
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
    private SysUserService sysUserService;

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
        System.out.println(Constant.Email.CODE_NAME_PREFIX + key);
        return redisTemplate.opsForValue().get(Constant.Email.CODE_NAME_PREFIX + key);
    }

    @Override
    public void destroyCode(String key) {
        redisTemplate.delete(Constant.Email.CODE_NAME_PREFIX + key);
    }

    @Override
    public Result check(Email email) {
        UserDetails userDetails = sysUserService.getByEmail(email.getUserEmail());
        if(userDetails != null){
            return Result.success("邮箱已注册");
        }
        return Result.failure("邮箱未注册");
    }

    @Override
    public Result checkCode(Email email) {
        String code = this.taskCode(email.getUserEmail());
        if(email.getCode().equals(code)){
            this.destroyCode(email.getUserEmail());
            return Result.success();
        }
        return Result.failure("验证码错误！");
    }
}

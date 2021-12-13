package com.example.demo.common.web.exception;

import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.exception.base.BusinessException;
import org.springframework.core.annotation.Order;
import org.springframework.mail.MailSendException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.mail.SendFailedException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLSyntaxErrorException;

/**
 * 全 局 异 常 处 理
 *
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 * */
@Order(2)
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 不 支 持 的 请 求 类 型
     * */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handleException(HttpRequestMethodNotSupportedException e){
        return Result.failure("不支持"+e.getMethod()+"请求");
    }

    /**
     * 未 知 的 运 行 时 异 常
     * */
    @ExceptionHandler(RuntimeException.class)
    public Result notFount(RuntimeException e){
        e.printStackTrace();
        return Result.failure("运行时异常：" + e.getMessage());
    }

    /**
     * 未 知 的 运 行 时 异 常
     * */
    @ExceptionHandler(SQLSyntaxErrorException.class)
    public Result notColumn(RuntimeException e){
        e.printStackTrace();
        return Result.failure("列不存在：" + e.getMessage());
    }

    /**
     * 系 统 异 常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e)
    {
        e.printStackTrace();
        return Result.failure("服务器错误，请联系管理员");
    }

    /**
     * 邮 箱 发 送 异 常
     */
    @ExceptionHandler(MailSendException.class)
    public Result sendFailedException(MailSendException e){
        e.printStackTrace();
        return Result.failure("邮箱发送异常，请检查邮箱是否正确！");
    }

    /**
     * 业 务 异 常
     * */
    @ExceptionHandler(BusinessException.class)
    public Result businessException(HttpServletRequest request, BusinessException e){
        return Result.failure(e.getMessage());
    }
}

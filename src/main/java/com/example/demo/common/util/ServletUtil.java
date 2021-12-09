package com.example.demo.common.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.constant.Constant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 工具类
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
public class ServletUtil {

    /**
     * 获取 HttpServletRequest 对象
     *
     * @return {@link HttpServletRequest}
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        return servletRequestAttributes.getRequest();
    }

    /**
     * 获取 HttpServletResponse 对象
     * @return {@link HttpServletResponse}
     */
    public static HttpServletResponse getResponse(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert servletRequestAttributes != null;
        return servletRequestAttributes.getResponse();
    }

    /**
     * Response 对象写出数据
     *
     * @param msg 消息数据
     */
    public static void write(String msg) throws IOException {
        HttpServletResponse response = getResponse();
        response.setHeader("Content-type","application/json;charset="+ Constant.System.UTF8);
        response.setCharacterEncoding(Constant.System.UTF8);
        response.getWriter().write(msg);
    }

    /**
     * Response 对象写出 JSON 数据
     *
     * @param data 消息数据
     */
    public static void writeJson(Object data) throws IOException {
        write(JSON.toJSONString(data));
    }

    /**
     * Request 请求地址
     *
     * @return {@link String}
     */
    public static String getRequestURI() {
        return getRequest().getRequestURI();
    }
}

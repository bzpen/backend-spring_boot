package com.example.demo.common.web.rest;

import com.example.demo.common.web.base.BaseController;
import com.example.demo.common.web.domain.Result;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


import javax.servlet.http.HttpServletRequest;

/**
 * 错误页面控制器
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
@RestController
@ApiIgnore
public class Error extends BaseController implements ErrorController {

    @RequestMapping("error")
    public Result handleError(HttpServletRequest request) {
        if (request == null) return failure();

        // 错误处理码
        int statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        // 错误消息
        String message = (String) request.getAttribute("javax.servlet.error.message");

        return failure(statusCode, message);
    }

}

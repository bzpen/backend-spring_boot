package com.example.demo.common.secure.uutoken;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.context.BeanContext;
import com.example.demo.common.util.PatternUtil;
import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.domain.ResultCode;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * token 验证
 *
 * @author kaito kuroba
 * @date 2021/12/8
 */
public class SecureUserTokenSupport extends OncePerRequestFilter {

    private final SecureUserTokenService customUserDetailsTokenService;

    public SecureUserTokenSupport(){
        this.customUserDetailsTokenService = BeanContext.getBean("secureUserTokenService",SecureUserTokenService.class);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletUtil.writeJson(Result.failure("没有token"));
    }

    /**
     * 不进行token验证
     * @param request
     * @return
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        List<String> pattern = Arrays.asList(Constant.Security.openApi);
        return PatternUtil.matches(pattern, ServletUtil.getRequestURI());
    }
}

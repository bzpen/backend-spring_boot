package com.example.demo.common.secure.uutoken;

import com.example.demo.common.constant.Constant;
import com.example.demo.common.context.BeanContext;
import com.example.demo.common.secure.services.SecureUser;
import com.example.demo.common.util.PatternUtil;
import com.example.demo.common.util.ServletUtil;
import com.example.demo.common.web.domain.Result;
import com.example.demo.common.web.domain.ResultCode;
import com.example.demo.common.web.exception.token.TokenExpiredException;
import com.example.demo.common.web.exception.token.TokenValidationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
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
        String tokenHeader = request.getHeader(Constant.Token.TOKEN_HEADER);
        // token param verify empty
        if (tokenHeader == null) { ServletUtil.writeJson(Result.failure(ResultCode.TOKEN_MISSION)); return;}
        // token verify
        SecureUser secureUser;
        try {
            SecureUserToken userToken = customUserDetailsTokenService.verifyToken(tokenHeader);
            secureUser = userToken.getSecureUser();
        }catch (TokenValidationException e){
            ServletUtil.writeJson(Result.failure(ResultCode.TOKEN_INVALID)); return;
        }catch (TokenExpiredException e){
            ServletUtil.writeJson(Result.failure(ResultCode.TOKEN_EXPIRED)); return;
        }
        // return UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(secureUser, secureUser.getId(), secureUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
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

package com.example.demo.common.email.sucrity.authentication.email;

import com.example.demo.common.email.service.EmailCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 邮件验证过滤器
 * 
 * @author kaito kuroba
 * @Email 3118659412@qq.com
 * @since 2021/12/11
 */
public class EmailAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    EmailCodeService emailCodeService;

    /**
     * 前端传来的 参数名 - 用于request.getParameter 获取
     */
    private final String DEFAULT_EMAIL_NAME="email";

    private final String DEFAULT_EMAIL_CODE="code";

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
    /**
     * 是否 仅仅post
     */
    private boolean postOnly = true;

    /**
     * 通过 传入的 参数 创建 匹配器
     * 即 Filter过滤的url
     */
    public EmailAuthenticationFilter() {
        super(new AntPathRequestMatcher("/user/email","POST"));
    }


    /**
     * 给权限
     * filter 获得 用户名（邮箱） 和 密码（验证码） 装配到 token 上 ，
     * 然后把token 交给 provider 进行授权
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if(postOnly && !request.getMethod().equals("POST") ){
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }else{

            String email = getEmail(request);
            if(email == null){
                email = "";
            }
            email = email.trim();

            //如果 验证码不相等 故意让token出错 然后走springsecurity 错误的流程
            boolean flag = checkCode(request);

            //封装 token
            EmailAuthenticationToken token = null;
            if(flag){
                token  = new EmailAuthenticationToken(email,new ArrayList<>());
            }else{
                token = new EmailAuthenticationToken("error");
            }
            this.setDetails(request,token);
            //交给 AuthenticationManager 进行认证 这个流程中在代码中有说明
            return this.getAuthenticationManager().authenticate(token);
        }
    }



    public void setDetails(HttpServletRequest request , EmailAuthenticationToken token ){
        token.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    /**
     * 获取 传来 的Email信息
     */
    public String getEmail(HttpServletRequest request ){
        String result=  request.getParameter(DEFAULT_EMAIL_NAME);
        return result;
    }


    /**
     * 判断 传来的 验证码信息 以及 redis 中的验证码信息
     */
    public boolean checkCode(HttpServletRequest request ){
        String code1 = request.getParameter(DEFAULT_EMAIL_CODE);
        String code = emailCodeService.taskCode(this.getEmail(request));
        if(code1.equals(code)){
            return true;
        }
        return false;
    }

}

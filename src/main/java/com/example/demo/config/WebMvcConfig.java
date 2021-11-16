package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    private TokenInterceptor tokenInterceptor;
//
//    //构造方法
//    public void WebConfiguration(TokenInterceptor tokenInterceptor){
//        this.tokenInterceptor = tokenInterceptor;
//    }

    /***
     * 跨域请求配置
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedOrigins("http://47.115.230.231:8084/","http://localhost:8084/"). //允许跨域的域名，可以用*表示允许任何域名使用
                        allowedMethods("*"). //允许任何方法（post、get等）
                        allowedHeaders("*"). //允许任何请求头
                        allowCredentials(true). //带上cookie信息
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
            }
        };
    }

/*
*     自定义拦截器
*     拦截查看token
*
* registration.excludePathPatterns("")   排除一些请求外其余请求均拦截
* registration.addPathPatterns("")       拦截写出的请求
*/

    /***
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration registration1 = registry.addInterceptor(new TokenInterceptor());
        registration1.excludePathPatterns("/admin/**","/spider/**");
    }

}

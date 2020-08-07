package xyz8.live.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz8.live.interceptor.CustomInterceptor;

import javax.annotation.Resource;

/**
 * @author LiangWei
 * @date 2020/8/7 15:13
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private CustomInterceptor customInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(customInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/doc.html/**");
    }
}

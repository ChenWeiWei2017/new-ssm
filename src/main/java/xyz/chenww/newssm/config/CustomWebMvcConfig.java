package xyz.chenww.newssm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.chenww.newssm.interceptor.LoginInterceptor;
import xyz.chenww.newssm.interceptor.TestInterceptor;

/**
 * 功能描述：配置拦截器
 *
 * @author chenweiwei
 * @since 2020/5/26
 */
@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器及对应的拦截api
     * 同一个url，先注册的拦截器先拦截，后处理
     * 执行顺序：LoginInterceptor.preHandle() -> TestInterceptor.preHandle() -> TestInterceptor.postHandle()
     *         -> LoginInterceptor.postHandle() -> TestInterceptor.afterCompletion() -> LoginInterceptor.afterCompletion()
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/api/v1/pri/**");
//        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/api/v1/pri/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}

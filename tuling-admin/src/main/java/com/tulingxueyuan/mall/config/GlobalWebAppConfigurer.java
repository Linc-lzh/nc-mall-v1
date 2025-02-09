package com.tulingxueyuan.mall.config;

import com.tulingxueyuan.mall.interceptor.AuthInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 权限验证拦截器
 * @author Linc
 * @since 2024-12-26
 */
@Configuration
public class GlobalWebAppConfigurer implements WebMvcConfigurer {

}

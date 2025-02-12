package com.tulingxueyuan.mall.config;

import com.tulingxueyuan.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 * @author Linc
 * @since 2024-12-26
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}

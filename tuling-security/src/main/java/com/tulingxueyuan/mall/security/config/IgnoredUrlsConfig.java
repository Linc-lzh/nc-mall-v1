package com.tulingxueyuan.mall.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/***
 * @author Linc
 * @since 2025-02-09
 */
@ConfigurationProperties(prefix = "secure.ignored")
public class  IgnoredUrlsConfig {
    private List<String> urls;

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}

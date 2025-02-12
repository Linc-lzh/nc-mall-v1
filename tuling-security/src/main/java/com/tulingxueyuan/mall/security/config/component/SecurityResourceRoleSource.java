package com.tulingxueyuan.mall.security.config.component;

import java.util.List;
import java.util.Map;

/***
 * @author Linc
 * @since 2025-02-09
 */
public interface SecurityResourceRoleSource {
    /**
     * 获取所有资源对应的橘色
     // key: 资源： /product/**
     // value: 角色
     * @return
     */
    Map<String, List<String>> getResourceRole();
}

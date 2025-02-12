package com.tulingxueyuan.mall.component.trade.alipay.service;

import com.alipay.api.response.MonitorHeartbeatSynResponse;
import com.tulingxueyuan.mall.component.trade.alipay.model.builder.AlipayHeartbeatSynRequestBuilder;

public interface AlipayMonitorService {

    // 交易保障接口 https://openhome.alipay.com/platform/document.htm#mobileApp-barcodePay-API-heartBeat

    // 可以提供给系统商/pos厂商使用
    public MonitorHeartbeatSynResponse heartbeatSyn(AlipayHeartbeatSynRequestBuilder builder);
}

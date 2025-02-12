package com.tulingxueyuan.mall.component.trade.alipay.service;

import com.tulingxueyuan.mall.component.trade.alipay.model.builder.AlipayTradePayRequestBuilder;
import com.tulingxueyuan.mall.component.trade.alipay.model.builder.AlipayTradePrecreateRequestBuilder;
import com.tulingxueyuan.mall.component.trade.alipay.model.builder.AlipayTradeQueryRequestBuilder;
import com.tulingxueyuan.mall.component.trade.alipay.model.builder.AlipayTradeRefundRequestBuilder;
import com.tulingxueyuan.mall.component.trade.alipay.model.result.AlipayF2FPayResult;
import com.tulingxueyuan.mall.component.trade.alipay.model.result.AlipayF2FPrecreateResult;
import com.tulingxueyuan.mall.component.trade.alipay.model.result.AlipayF2FQueryResult;
import com.tulingxueyuan.mall.component.trade.alipay.model.result.AlipayF2FRefundResult;

public interface AlipayTradeService {

    // 当面付2.0流程支付
    public AlipayF2FPayResult tradePay(AlipayTradePayRequestBuilder builder);

    // 当面付2.0消费查询
    public AlipayF2FQueryResult queryTradeResult(AlipayTradeQueryRequestBuilder builder);

    // 当面付2.0消费退款
    public AlipayF2FRefundResult tradeRefund(AlipayTradeRefundRequestBuilder builder);

    // 当面付2.0预下单(生成二维码)
    public AlipayF2FPrecreateResult tradePrecreate(AlipayTradePrecreateRequestBuilder builder);
}

package com.tulingxueyuan.mall.component.trade.alipay.model.result;

import com.alipay.api.response.AlipayTradePayResponse;
import com.tulingxueyuan.mall.component.trade.alipay.model.TradeStatus;

public class AlipayF2FPayResult implements Result {
    private TradeStatus tradeStatus;
    private AlipayTradePayResponse response;

    public AlipayF2FPayResult(AlipayTradePayResponse response) {
        this.response = response;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public void setResponse(AlipayTradePayResponse response) {
        this.response = response;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public AlipayTradePayResponse getResponse() {
        return response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}

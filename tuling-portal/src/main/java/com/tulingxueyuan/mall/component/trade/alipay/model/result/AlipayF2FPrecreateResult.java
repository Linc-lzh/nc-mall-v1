package com.tulingxueyuan.mall.component.trade.alipay.model.result;

import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.tulingxueyuan.mall.component.trade.alipay.model.TradeStatus;

public class AlipayF2FPrecreateResult implements Result {
    private TradeStatus tradeStatus;
    private AlipayTradePrecreateResponse response;

    public AlipayF2FPrecreateResult(AlipayTradePrecreateResponse response) {
        this.response = response;
    }

    public void setTradeStatus(TradeStatus tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public void setResponse(AlipayTradePrecreateResponse response) {
        this.response = response;
    }

    public TradeStatus getTradeStatus() {
        return tradeStatus;
    }

    public AlipayTradePrecreateResponse getResponse() {
        return response;
    }

    @Override
    public boolean isTradeSuccess() {
        return response != null &&
                TradeStatus.SUCCESS.equals(tradeStatus);
    }
}

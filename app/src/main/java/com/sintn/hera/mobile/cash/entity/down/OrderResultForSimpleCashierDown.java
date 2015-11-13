package com.sintn.hera.mobile.cash.entity.down;

/**
 * 简单收银->创建订单结果下行实体
 */
public class OrderResultForSimpleCashierDown {
    // 订单ID
    private long orderId;

    // 二维码
    private String qrcode;

    // 在线支付超时时间，单位毫秒
    private long payTimeout;

    public OrderResultForSimpleCashierDown() {
    }

    public OrderResultForSimpleCashierDown(long payTimeout, long orderId, String qrcode) {
        this.payTimeout = payTimeout;
        this.orderId = orderId;
        this.qrcode = qrcode;
    }

    public long getPayTimeout() {
        return payTimeout == 0 ? 360 : payTimeout;
    }

    public void setPayTimeout(long payTimeout) {
        this.payTimeout = payTimeout;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}

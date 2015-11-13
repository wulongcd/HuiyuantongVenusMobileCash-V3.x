package com.sintn.hera.mobile.cash.entity.down;

/**
 * 简易收银流水累计金额的下行实体
 */
public class TotalMoneyForSimpleCashierDown {
    // 微信支付笔数
    private int weixinCount;

    // 微信支付累计金额
    private double weixinMoney;

    // 支付宝笔数
    private int alipayCount;

    // 支付宝累计金额
    private double alipayMoney;

    public TotalMoneyForSimpleCashierDown() {
    }

    public int getWeixinCount() {
        return weixinCount;
    }

    public void setWeixinCount(int weixinCount) {
        this.weixinCount = weixinCount;
    }

    public double getWeixinMoney() {
        return weixinMoney;
    }

    public void setWeixinMoney(double weixinMoney) {
        this.weixinMoney = weixinMoney;
    }

    public int getAlipayCount() {
        return alipayCount;
    }

    public void setAlipayCount(int alipayCount) {
        this.alipayCount = alipayCount;
    }

    public double getAlipayMoney() {
        return alipayMoney;
    }

    public void setAlipayMoney(double alipayMoney) {
        this.alipayMoney = alipayMoney;
    }
}

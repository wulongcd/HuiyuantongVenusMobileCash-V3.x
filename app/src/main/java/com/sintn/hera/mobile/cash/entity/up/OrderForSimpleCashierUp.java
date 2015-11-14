package com.sintn.hera.mobile.cash.entity.up;

/**
 * 简单收银->收银订单上行实体
 */
public class OrderForSimpleCashierUp
{
	// 金额
	private double money;
	
	// 在线支付方式，参见OnlinePaymentType类
	private int paymentType;
	
	// 订单是否重复的token
	private String repeatToken;

	public OrderForSimpleCashierUp() {
	}

	public OrderForSimpleCashierUp(double money, int paymentType, String repeatToken) {
		this.money = money;
		this.paymentType = paymentType;
		this.repeatToken = repeatToken;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public String getRepeatToken() {
		return repeatToken;
	}

	public void setRepeatToken(String repeatToken) {
		this.repeatToken = repeatToken;
	}
}

package com.sintn.hera.mobile.cash.entity.down;

import java.util.Date;

/**
 * 
 * @Desc: 收入流水的下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @OnlinePayOrderForBossDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-10下午3:47:57
 */
public class OnlinePayOrderForBossDown
{
	// 店铺名称
	private String shopName;

	// 支付方式，参见BuyerPaymentType类
	private String paymentType;
	// 到账与否
	private boolean to;
	// 交易金额
	private double tradeMoney;

	// 手续费
	private double handlingCharge;

	// 收入金额
	private double incomeMoney;

	// 交易时间
	private Date date;

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	public boolean isTo()
	{
		return to;
	}

	public void setTo(boolean to)
	{
		this.to = to;
	}

	public double getTradeMoney()
	{
		return tradeMoney;
	}

	public void setTradeMoney(double tradeMoney)
	{
		this.tradeMoney = tradeMoney;
	}

	public double getHandlingCharge()
	{
		return handlingCharge;
	}

	public void setHandlingCharge(double handlingCharge)
	{
		this.handlingCharge = handlingCharge;
	}

	public double getIncomeMoney()
	{
		return incomeMoney;
	}

	public void setIncomeMoney(double incomeMoney)
	{
		this.incomeMoney = incomeMoney;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

}

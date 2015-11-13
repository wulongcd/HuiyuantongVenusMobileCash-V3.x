package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 在线购物下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @OnlineBuyDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:09:31
 */
public class OnlineBuyDown
{
	// 合计
	private double totalMoney;
	// 在线充值的金额
	private double rechargeMoney;

	// 在线充值赠送的金额
	private double rechargePresentMoney;

	// 在线充值赠送的积分
	private int rechargePresentScore;

	// 在线购买套餐的数量
	private int saleGroupAmount;

	// 在线购买套餐的价值
	private double saleGroupValue;

	// 现金支付的在线购物
	private double cash;

	// 会员卡支付的在线购物
	private double card;

	public double getTotalMoney()
	{
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney)
	{
		this.totalMoney = totalMoney;
	}

	public double getRechargeMoney()
	{
		return rechargeMoney;
	}

	public void setRechargeMoney(double rechargeMoney)
	{
		this.rechargeMoney = rechargeMoney;
	}

	public double getRechargePresentMoney()
	{
		return rechargePresentMoney;
	}

	public void setRechargePresentMoney(double rechargePresentMoney)
	{
		this.rechargePresentMoney = rechargePresentMoney;
	}

	public int getRechargePresentScore()
	{
		return rechargePresentScore;
	}

	public void setRechargePresentScore(int rechargePresentScore)
	{
		this.rechargePresentScore = rechargePresentScore;
	}

	public int getSaleGroupAmount()
	{
		return saleGroupAmount;
	}

	public void setSaleGroupAmount(int saleGroupAmount)
	{
		this.saleGroupAmount = saleGroupAmount;
	}

	public double getSaleGroupValue()
	{
		return saleGroupValue;
	}

	public void setSaleGroupValue(double saleGroupValue)
	{
		this.saleGroupValue = saleGroupValue;
	}

	public double getCash()
	{
		return cash;
	}

	public void setCash(double cash)
	{
		this.cash = cash;
	}

	public double getCard()
	{
		return card;
	}

	public void setCard(double card)
	{
		this.card = card;
	}
}

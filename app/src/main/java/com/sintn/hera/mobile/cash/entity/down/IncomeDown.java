package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 收入下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @IncomeDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:08:58
 */
public class IncomeDown
{
	// 累计（现金+银联+微信+支付宝）
	private double total;
	
	// 现金
	private double cash;
	
	// 银联
	private double bank;
	
	// 微信
	private double weixin;
	
	// 支付宝
	private double ali;

	public double getTotal()
	{
		return total;
	}

	public void setTotal(double total)
	{
		this.total = total;
	}

	public double getCash()
	{
		return cash;
	}

	public void setCash(double cash)
	{
		this.cash = cash;
	}

	public double getBank()
	{
		return bank;
	}

	public void setBank(double bank)
	{
		this.bank = bank;
	}

	public double getWeixin()
	{
		return weixin;
	}

	public void setWeixin(double weixin)
	{
		this.weixin = weixin;
	}

	public double getAli()
	{
		return ali;
	}

	public void setAli(double ali)
	{
		this.ali = ali;
	}
}

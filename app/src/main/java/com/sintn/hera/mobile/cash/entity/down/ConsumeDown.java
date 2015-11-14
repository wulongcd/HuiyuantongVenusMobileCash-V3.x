package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 消费下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @ConsumeDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:08:18
 */
public class ConsumeDown
{
	// 累计（现金+银联+微信+支付宝+会员卡）
	private double total;

	// 现金
	private double cash;

	// 银联
	private double bank;

	// 微信
	private double weixin;

	// 支付宝
	private double ali;

	// 会员卡
	private double card;

	// 抵用商品数量
	private double productAmount;

	// 抵用商品价值
	private double productValue;

	// 代金券数量
	private int cashCouponAmount;

	// 代金券价值
	private double cashCouponValue;

	// 折扣券数量
	private int discountCouponAmount;

	// 使用的积分
	private int useScore;

	// 赠送的积分
	private int presentScore;

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

	public double getCard()
	{
		return card;
	}

	public void setCard(double card)
	{
		this.card = card;
	}

	public double getProductAmount()
	{
		return productAmount;
	}

	public void setProductAmount(double productAmount)
	{
		this.productAmount = productAmount;
	}

	public double getProductValue()
	{
		return productValue;
	}

	public void setProductValue(double productValue)
	{
		this.productValue = productValue;
	}

	public int getCashCouponAmount()
	{
		return cashCouponAmount;
	}

	public void setCashCouponAmount(int cashCouponAmount)
	{
		this.cashCouponAmount = cashCouponAmount;
	}

	public double getCashCouponValue()
	{
		return cashCouponValue;
	}

	public void setCashCouponValue(double cashCouponValue)
	{
		this.cashCouponValue = cashCouponValue;
	}

	public int getDiscountCouponAmount()
	{
		return discountCouponAmount;
	}

	public void setDiscountCouponAmount(int discountCouponAmount)
	{
		this.discountCouponAmount = discountCouponAmount;
	}

	public int getUseScore()
	{
		return useScore;
	}

	public void setUseScore(int useScore)
	{
		this.useScore = useScore;
	}

	public int getPresentScore()
	{
		return presentScore;
	}

	public void setPresentScore(int presentScore)
	{
		this.presentScore = presentScore;
	}
}

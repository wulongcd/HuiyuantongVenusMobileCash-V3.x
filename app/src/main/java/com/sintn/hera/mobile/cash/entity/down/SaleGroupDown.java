package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 购买套餐下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @SaleGroupDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:10:51
 */
public class SaleGroupDown
{
	/**
	 * 购买套餐的数量
	 * 
	 */
	private int amount;

	/**
	 * 购买套餐的金额（最终价）
	 * 
	 */
	private double value;

	/**
	 * 购买套餐赠送的积分
	 * 
	 */
	private int score;

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}
}

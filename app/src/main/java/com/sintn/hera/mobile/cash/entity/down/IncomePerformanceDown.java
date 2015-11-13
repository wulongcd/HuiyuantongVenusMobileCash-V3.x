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
public class IncomePerformanceDown
{
	// 总业绩
	private double totalPerformance;
	
	// 总提成
	private double cash;
	
	// 点客
	private int specifyCustomer;
	
	// 生客
	private int normalCustomer;
	
	//笔数
	private int count;

	public double getTotalPerformance()
	{
		return totalPerformance;
	}

	public void setTotalPerformance(double totalPerformance)
	{
		this.totalPerformance = totalPerformance;
	}

	public double getCash()
	{
		return cash;
	}

	public void setCash(double cash)
	{
		this.cash = cash;
	}

	public int getSpecifyCustomer()
	{
		return specifyCustomer;
	}

	public void setSpecifyCustomer(int specifyCustomer)
	{
		this.specifyCustomer = specifyCustomer;
	}

	public int getNormalCustomer()
	{
		return normalCustomer;
	}

	public void setNormalCustomer(int normalCustomer)
	{
		this.normalCustomer = normalCustomer;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}
	
}

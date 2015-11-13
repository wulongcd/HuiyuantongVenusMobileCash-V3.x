package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 业绩下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @ConsumeDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:08:18
 */
public class PerformanceDown
{
	//总业绩
	private double totalPerformance;
	//总提成
	private double totalIncome;
	//总笔数
	private long totalCount;
	//特殊消费者（指定理发师之类的）
	private long specifiedCustomer;
	//一般消费者
	private long nomalCustomer;

	//销售业绩
	private double salePerformance;
	//销售提成
	private double saleIncome;
	//销售笔数
	private long saleCount;

	//充值业绩
	private double rechargePerformance;
	//充值提成
	private double rechargeIncome;
	//充值笔数
	private long rechargeCount;

	//套餐业绩
	private double packagePerformance;
	//套餐提成
	private double packageIncome;
	//套餐笔数
	private long packageCount;
	
	public PerformanceDown()
	{
	}

	public PerformanceDown(double totalPerformance, double totalIncome, long totalCount, long specifiedCustomer, long nomalCustomer, double salePerformance, double saleIncome, long saleCount,
			double rechargePerformance, double rechargeIncome, long rechargeCount, double packagePerformance, double packageIncome, long packageCount)
	{
		super();
		this.totalPerformance = totalPerformance;
		this.totalIncome = totalIncome;
		this.totalCount = totalCount;
		this.specifiedCustomer = specifiedCustomer;
		this.nomalCustomer = nomalCustomer;
		this.salePerformance = salePerformance;
		this.saleIncome = saleIncome;
		this.saleCount = saleCount;
		this.rechargePerformance = rechargePerformance;
		this.rechargeIncome = rechargeIncome;
		this.rechargeCount = rechargeCount;
		this.packagePerformance = packagePerformance;
		this.packageIncome = packageIncome;
		this.packageCount = packageCount;
	}

	public double getTotalPerformance()
	{
		return totalPerformance;
	}

	public void setTotalPerformance(double totalPerformance)
	{
		this.totalPerformance = totalPerformance;
	}

	public double getTotalIncome()
	{
		return totalIncome;
	}

	public void setTotalIncome(double totalIncome)
	{
		this.totalIncome = totalIncome;
	}

	public long getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(long totalCount)
	{
		this.totalCount = totalCount;
	}

	public long getSpecifiedCustomer()
	{
		return specifiedCustomer;
	}

	public void setSpecifiedCustomer(long specifiedCustomer)
	{
		this.specifiedCustomer = specifiedCustomer;
	}

	public long getNomalCustomer()
	{
		return nomalCustomer;
	}

	public void setNomalCustomer(long nomalCustomer)
	{
		this.nomalCustomer = nomalCustomer;
	}

	public double getSalePerformance()
	{
		return salePerformance;
	}

	public void setSalePerformance(double salePerformance)
	{
		this.salePerformance = salePerformance;
	}

	public double getSaleIncome()
	{
		return saleIncome;
	}

	public void setSaleIncome(double saleIncome)
	{
		this.saleIncome = saleIncome;
	}

	public long getSaleCount()
	{
		return saleCount;
	}

	public void setSaleCount(long saleCount)
	{
		this.saleCount = saleCount;
	}

	public double getRechargePerformance()
	{
		return rechargePerformance;
	}

	public void setRechargePerformance(double rechargePerformance)
	{
		this.rechargePerformance = rechargePerformance;
	}

	public double getRechargeIncome()
	{
		return rechargeIncome;
	}

	public void setRechargeIncome(double rechargeIncome)
	{
		this.rechargeIncome = rechargeIncome;
	}

	public long getRechargeCount()
	{
		return rechargeCount;
	}

	public void setRechargeCount(long rechargeCount)
	{
		this.rechargeCount = rechargeCount;
	}

	public double getPackagePerformance()
	{
		return packagePerformance;
	}

	public void setPackagePerformance(double packagePerformance)
	{
		this.packagePerformance = packagePerformance;
	}

	public double getPackageIncome()
	{
		return packageIncome;
	}

	public void setPackageIncome(double packageIncome)
	{
		this.packageIncome = packageIncome;
	}

	public long getPackageCount()
	{
		return packageCount;
	}

	public void setPackageCount(long packageCount)
	{
		this.packageCount = packageCount;
	}
	
}

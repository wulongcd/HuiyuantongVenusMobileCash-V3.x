package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 客流量详情下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @PassengerFlowItemDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:09:55
 */
public class PassengerFlowItemDown
{
	// 商品分类的名称
	private String name;
	// 男客数量
	private int male;

	// 女客数量
	private int female;

	// 未知性别数量
	private int unknown;

	/**
	 * show
	 */
	// 客流量
	private int amount;

	public PassengerFlowItemDown(int amount)
	{
		super();
		this.amount = amount;
	}

	public PassengerFlowItemDown()
	{
		super();
	}

	public PassengerFlowItemDown(String name, int male, int female, int unknown)
	{
		super();
		this.name = name;
		this.male = male;
		this.female = female;
		this.unknown = unknown;
	}

	public PassengerFlowItemDown(String name, int male, int female, int unknown, int amount)
	{
		super();
		this.name = name;
		this.male = male;
		this.female = female;
		this.unknown = unknown;
		this.amount = amount;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getMale()
	{
		return male;
	}

	public void setMale(int male)
	{
		this.male = male;
	}

	public int getFemale()
	{
		return female;
	}

	public void setFemale(int female)
	{
		this.female = female;
	}

	public int getUnknown()
	{
		return unknown;
	}

	public void setUnknown(int unknown)
	{
		this.unknown = unknown;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	
}

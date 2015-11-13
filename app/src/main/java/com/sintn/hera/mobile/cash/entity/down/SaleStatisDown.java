package com.sintn.hera.mobile.cash.entity.down;

public class SaleStatisDown
{

	//对象ID-(套餐ID或者商品ID)
	private long objId;
	
	//对象名称
	private String name;
	
	//销售额
	private long amount;
	
	//对象种类：1-商品，3-套餐,参考com.sintn.venus.constant.OrderItemType
	private int type;

	public SaleStatisDown()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public long getObjId()
	{
		return objId;
	}

	public void setObjId(long objId)
	{
		this.objId = objId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getAmount()
	{
		return amount;
	}

	public void setAmount(long amount)
	{
		this.amount = amount;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

}

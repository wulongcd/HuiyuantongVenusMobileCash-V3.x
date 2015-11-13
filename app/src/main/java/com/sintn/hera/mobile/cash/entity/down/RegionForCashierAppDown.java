package com.sintn.hera.mobile.cash.entity.down;

/**
 * 收款宝->地区的下行实体
 */
public class RegionForCashierAppDown
{
	// 地区ID
	private long id;
	
	// 编号
	private String code;
	
	// 名称
	private String name;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}

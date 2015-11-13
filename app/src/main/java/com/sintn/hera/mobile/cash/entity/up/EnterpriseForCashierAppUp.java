package com.sintn.hera.mobile.cash.entity.up;

import java.util.List;

/**
 * 收款宝->更新企业基本信息的上行实体
 */
public class EnterpriseForCashierAppUp
{
	// 企业名称，必填，1-14个字符组成，不能包含特殊字符
	private String name;
	
	// 一级行业ID，必填
	private long category1Id;
	
	// 二级行业ID列表，必填，至少一个
	private List<Long> category2Ids;
	
	// 企业地址，必填，1-50个字符组成，不能包含特殊字符
	private String address;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getCategory1Id()
	{
		return category1Id;
	}

	public void setCategory1Id(long category1Id)
	{
		this.category1Id = category1Id;
	}

	public List<Long> getCategory2Ids()
	{
		return category2Ids;
	}

	public void setCategory2Ids(List<Long> category2Ids)
	{
		this.category2Ids = category2Ids;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
}

package com.sintn.hera.mobile.cash.entity.down;

import java.util.List;

/**
 * 收款宝->企业基本信息的下行实体
 */
public class EnterpriseForCashierAppDown
{
	// 企业名称
	private String name;
	
	// 一级行业
	private CategoryForCashierAppDown category1;
	
	// 二级行业列表
	private List<CategoryForCashierAppDown> category2s;
	
	// 企业地址
	private String address;
	
	// 手机号码
	private String phone;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public CategoryForCashierAppDown getCategory1()
	{
		return category1;
	}

	public void setCategory1(CategoryForCashierAppDown category1)
	{
		this.category1 = category1;
	}

	public List<CategoryForCashierAppDown> getCategory2s()
	{
		return category2s;
	}

	public void setCategory2s(List<CategoryForCashierAppDown> category2s)
	{
		this.category2s = category2s;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}

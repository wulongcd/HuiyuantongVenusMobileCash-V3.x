package com.sintn.hera.mobile.cash.entity.down;

/**
 * 收款宝->银行的下行实体
 */
public class BankForCashierAppDown
{
	// 银行名称
	private String name;
	
	// 银行logo，图片名称，带后缀，为空
	private String logo;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLogo()
	{
		return logo;
	}

	public void setLogo(String logo)
	{
		this.logo = logo;
	}
}

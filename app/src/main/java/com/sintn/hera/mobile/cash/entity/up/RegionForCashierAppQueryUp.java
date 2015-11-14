package com.sintn.hera.mobile.cash.entity.up;


/**
 * 收款宝->查询下级地区的上行实体
 */
public class RegionForCashierAppQueryUp extends CommonPagerUp
{
	// 上级地区的code
	private String code;

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
}

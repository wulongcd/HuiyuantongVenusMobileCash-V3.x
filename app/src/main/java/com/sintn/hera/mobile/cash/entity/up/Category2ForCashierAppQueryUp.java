package com.sintn.hera.mobile.cash.entity.up;

/**
 * 收款宝->二级行业查询条件的上行实体
 */
public class Category2ForCashierAppQueryUp extends CommonPagerUp
{
	// 一级行业的ID
	private long id;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
}

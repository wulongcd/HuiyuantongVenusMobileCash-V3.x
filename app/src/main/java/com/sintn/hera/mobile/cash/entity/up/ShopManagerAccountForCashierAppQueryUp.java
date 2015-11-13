package com.sintn.hera.mobile.cash.entity.up;


/**
 * 收款宝->查询指定店铺的管理员（收银员）列表的查询条件的上行实体
 */
public class ShopManagerAccountForCashierAppQueryUp extends CommonPagerUp
{
	// 店铺ID
	private long shopId;

	public long getShopId()
	{
		return shopId;
	}

	public void setShopId(long shopId)
	{
		this.shopId = shopId;
	}
}

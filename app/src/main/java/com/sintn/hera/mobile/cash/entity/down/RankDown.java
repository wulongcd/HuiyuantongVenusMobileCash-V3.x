package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 店铺排行的结果
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @RankDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:10:08
 */
public class RankDown
{
	// 店铺名称
	private String shopName;

	// 排行内容的数量
	private double value;

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}
}

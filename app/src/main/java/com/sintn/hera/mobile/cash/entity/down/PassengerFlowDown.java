package com.sintn.hera.mobile.cash.entity.down;

import java.util.List;

/**
 * 
 * @Desc: 客流量下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @PassengerFlowDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:09:43
 */
public class PassengerFlowDown
{
	// 客流量
	private int amount;

	// 客流量详情
	private List<PassengerFlowItemDown> items;

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public List<PassengerFlowItemDown> getItems()
	{
		return items;
	}

	public void setItems(List<PassengerFlowItemDown> items)
	{
		this.items = items;
	}
}

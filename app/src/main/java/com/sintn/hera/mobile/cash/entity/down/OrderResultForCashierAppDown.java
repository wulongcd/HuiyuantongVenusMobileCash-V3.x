package com.sintn.hera.mobile.cash.entity.down;

/**
 * 收款宝->创建订单的下行实体
 */
public class OrderResultForCashierAppDown
{
	// 订单ID
	private long orderId;
	
	// 二维码
	private String qrcode;

	public long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(long orderId)
	{
		this.orderId = orderId;
	}

	public String getQrcode()
	{
		return qrcode;
	}

	public void setQrcode(String qrcode)
	{
		this.qrcode = qrcode;
	}
}

package com.sintn.hera.mobile.cash.entity.down;

import com.sintn.hera.mobile.cash.entity.conast.OnlinePaymentType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 收款宝->查询订单列表的下行实体
 */
public class OrderForCashierAppDown
{
	// 创建时间
	private String createDate;
	
	// 金额
	private double money;
	
	// 在线支付方式
	private String paymentType;

	private  TotalMoneyForSimpleCashierDown total;
	
	public OrderForCashierAppDown()
	{
		
	}

	public OrderForCashierAppDown(TotalMoneyForSimpleCashierDown total) {
		this.total = total;
	}

	public OrderForCashierAppDown(Date createDate, Double money, Integer paymentType)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.createDate = format.format(createDate);
		this.money = money;
		
		if(paymentType == OnlinePaymentType.ALIPAY_QRCODE_USER_SCAN)
		{
			this.paymentType = "支付宝";
		}
		else if(paymentType == OnlinePaymentType.WEIXIN_QRCODE_USER_SCAN)
		{
			this.paymentType = "微信";
		}
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public double getMoney()
	{
		return money;
	}

	public void setMoney(double money)
	{
		this.money = money;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	public TotalMoneyForSimpleCashierDown getTotal() {
		return total;
	}

	public void setTotal(TotalMoneyForSimpleCashierDown total) {
		this.total = total;
	}
}

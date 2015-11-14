package com.sintn.hera.mobile.cash.entity.down;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Desc: 充值下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @RechargeDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:10:17
 */
public class RechargeDown
{

	//提成明细ID
	private long id;
	
	//会员名称customerName-cname
	private String cname;
	
	//卡片类型名称
	private String cardName;
	
	//充值金额
	private double money;
	
	//支付方式paymentType-p
	private String p;
	
	//赠送金额presentMoney-pm
	private double pm;
	
	//赠送积分presentScore-ps
	private long ps;
	
	//业绩
	private double saleMoney;
	
	//提成金额
	private double dividend;
	
	//订单交易时间,不是提成时间
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	//订单流水号
	private String code;

	public RechargeDown()
	{
		super();
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public String getCardName()
	{
		return cardName;
	}

	public void setCardName(String cardName)
	{
		this.cardName = cardName;
	}

	public double getMoney()
	{
		return money;
	}

	public void setMoney(double money)
	{
		this.money = money;
	}

	public String getP()
	{
		return p;
	}

	public void setP(String p)
	{
		this.p = p;
	}

	public double getPm()
	{
		return pm;
	}

	public void setPm(double pm)
	{
		this.pm = pm;
	}

	public long getPs()
	{
		return ps;
	}

	public void setPs(long ps)
	{
		this.ps = ps;
	}

	public double getSaleMoney()
	{
		return saleMoney;
	}

	public void setSaleMoney(double saleMoney)
	{
		this.saleMoney = saleMoney;
	}

	public double getDividend()
	{
		return dividend;
	}

	public void setDividend(double dividend)
	{
		this.dividend = dividend;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
	
}

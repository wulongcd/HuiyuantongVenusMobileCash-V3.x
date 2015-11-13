package com.sintn.hera.mobile.cash.entity.down;

import java.util.Date;

/**
 * 
 * @Desc: 提现流水的下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @WithdrawOrderForBossDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-10下午3:47:13
 */
public class WithdrawOrderForBossDown
{
	// 标题
	private String title;

	// 提现账户
	private String accountName;

	// 银行名称
	private String bankName;

	// 银行卡卡号
	private String cardCode;

	// 提现金额
	private double money;

	// 提现前金额
	private double preMoney;

	// 提现后金额
	private double postMoney;

	// 提现时间
	private Date date;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getCardCode()
	{
		return cardCode;
	}

	public void setCardCode(String cardCode)
	{
		this.cardCode = cardCode;
	}

	public double getMoney()
	{
		return money;
	}

	public void setMoney(double money)
	{
		this.money = money;
	}

	public double getPreMoney()
	{
		return preMoney;
	}

	public void setPreMoney(double preMoney)
	{
		this.preMoney = preMoney;
	}

	public double getPostMoney()
	{
		return postMoney;
	}

	public void setPostMoney(double postMoney)
	{
		this.postMoney = postMoney;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

}

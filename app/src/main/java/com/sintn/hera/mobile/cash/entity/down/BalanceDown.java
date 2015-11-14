package com.sintn.hera.mobile.cash.entity.down;

import java.io.Serializable;

/**
 * 
 * @Desc: 企业账户余额
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @BalanceDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:07:35
 */
@SuppressWarnings("serial")
public class BalanceDown implements Serializable
{
	/**
	 * 到账金额
	 */
	private double toAccount;

	/**
	 * 未到账金额
	 */
	private double notToAccount;

	public double getToAccount()
	{
		return toAccount;
	}

	public void setToAccount(double toAccount)
	{
		this.toAccount = toAccount;
	}

	public double getNotToAccount()
	{
		return notToAccount;
	}

	public void setNotToAccount(double notToAccount)
	{
		this.notToAccount = notToAccount;
	}
}

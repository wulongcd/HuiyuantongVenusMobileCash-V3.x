package com.sintn.hera.mobile.cash.entity.down;

/**
 * 收款宝->到账金额的下行实体
 */
public class BalanceForCashierAppDown
{
	// 到账金额
	private double toAccount;
	
	// 未到账金额
	private double notToAccount;

	//提现密码
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

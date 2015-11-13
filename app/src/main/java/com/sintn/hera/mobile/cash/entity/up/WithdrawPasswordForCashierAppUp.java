package com.sintn.hera.mobile.cash.entity.up;

/**
 * 收款宝->提现密码上行实体
 */
public class WithdrawPasswordForCashierAppUp
{
	// 提现密码，必填，MD5加密的字符串
	private String password;

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}

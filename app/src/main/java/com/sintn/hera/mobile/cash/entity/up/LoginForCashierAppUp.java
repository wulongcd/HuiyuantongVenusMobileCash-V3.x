package com.sintn.hera.mobile.cash.entity.up;

/**
 * 收款宝->登录上行实体
 */
public class LoginForCashierAppUp
{
	// 用户名称
	private String username;
	
	// 密码
	private String password;

	public LoginForCashierAppUp(String username, String password) {
		this.password = password;
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}

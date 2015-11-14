package com.sintn.hera.mobile.cash.entity.up;

/**
 * 收款宝->提现订单上行实体
 */
public class WithdrawForCashierAppUp
{
	// 提现账户ID
	private long id;
	
	// 提现金额
	private double value;
	
	// 手机号
	private String phone;
	
	// 验证码
	private String code;
	
	// 提现密码
	private String password;
	
	// 防止重复提交的token
	private String token;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value)
	{
		this.value = value;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}
}

package com.sintn.hera.mobile.cash.entity.up;

public class ResetPasswordUp
{
	private String phone;
	private String password;
	
	public ResetPasswordUp(String phone, String password)
	{
		super();
		this.phone = phone;
		this.password = password;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
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

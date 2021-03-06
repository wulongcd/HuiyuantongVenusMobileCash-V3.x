package com.sintn.hera.mobile.cash.entity.up;

/**
 * 
 * @Desc: 登录的上行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:04:49
 */
public class LoginUp
{
	// 企业后台管理员的用户名称
	private String username;
	
	// 密码
	private String password;
	
	// 设备的mac地址
	private String mac;

	public LoginUp(String username, String password, String mac)
	{
		super();
		this.username = username;
		this.password = password;
		this.mac = mac;
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

	public String getMac()
	{
		return mac;
	}

	public void setMac(String mac)
	{
		this.mac = mac;
	}
}

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
public class LoginInfoUp
{
	/**
	 * 用户名,由6-16个可见字符组成,登录时系统后台不检查长度
	 */
	private String username;
	
	/**
	 * 密码,由6-16个可见字符组成,必须包含字母和数字,登录时系统后台不检查长度
	 */
	private String password;

	
	public LoginInfoUp(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
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

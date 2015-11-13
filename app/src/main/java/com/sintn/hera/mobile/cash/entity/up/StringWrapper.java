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
public class StringWrapper
{
	// 企业后台管理员的用户名称
	private String str;
	
	// 设备的mac地址
//	private String mac;

	public StringWrapper(String username)
	{
		super();
		this.str = username;
	}

	public String getStr()
	{
		return str;
	}

	public void setStr(String username)
	{
		this.str = username;
	}

//	public String getMac()
//	{
//		return mac;
//	}
//
//	public void setMac(String mac)
//	{
//		this.mac = mac;
//	}
}

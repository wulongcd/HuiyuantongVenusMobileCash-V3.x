package com.sintn.hera.mobile.cash.entity.up;

/**
 * 
 * @Desc: 获取验证码的上行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @ICUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:04:26
 */
public class ICUp
{
	// 手机号
	private String phone;

	public ICUp()
	{
		super();
	}

	public ICUp(String phone)
	{
		super();
		this.phone = phone;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
}

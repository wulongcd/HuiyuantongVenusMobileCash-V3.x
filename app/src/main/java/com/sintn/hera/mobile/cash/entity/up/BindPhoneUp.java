package com.sintn.hera.mobile.cash.entity.up;

/**
 * 
 * @Desc: 绑定手机的上行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @BindPhoneUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:04:02
 */
public class BindPhoneUp
{
	// 手机号
	private String phone;

	// 验证码
	private String code;

	public BindPhoneUp(String phone, String code)
	{
		super();
		this.phone = phone;
		this.code = code;
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
}

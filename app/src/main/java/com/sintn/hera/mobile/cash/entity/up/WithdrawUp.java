package com.sintn.hera.mobile.cash.entity.up;

/**
 * 
 * @Desc: 提现的上行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @WithdrawUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:06:26
 */
public class WithdrawUp
{
	// 绑定的银行卡ID
	private long bindingBankCardId;

	// 提现金额
	private double value;

	// 手机号
	private String phone;

	// 验证码
	private String code;

	// 防止重复提交的token
	private String token;

	public long getBindingBankCardId()
	{
		return bindingBankCardId;
	}

	public void setBindingBankCardId(long bindingBankCardId)
	{
		this.bindingBankCardId = bindingBankCardId;
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

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

}

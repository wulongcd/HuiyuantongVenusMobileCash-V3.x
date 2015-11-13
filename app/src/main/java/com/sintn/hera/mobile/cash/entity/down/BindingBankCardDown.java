package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 绑定的银行卡下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @BindingBankCardDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-2上午9:36:27
 */
public class BindingBankCardDown
{
	// ID
	private long id;

	// 银行类型，参见BankType类
	private int bankType;

	// 银行名称
	private String bankName;

	// 银行卡类型名称
	private String cardName;

	// 银行卡logo
	private String cardLogo;

	// 银行卡卡号
	private String cardCode;

	// 账户名称
	private String accountName;

	// 省
	private String province;

	// 市
	private String city;

	// ***支行
	private String subbranch;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public int getBankType()
	{
		return bankType;
	}

	public void setBankType(int bankType)
	{
		this.bankType = bankType;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getCardName()
	{
		return cardName;
	}

	public void setCardName(String cardName)
	{
		this.cardName = cardName;
	}

	public String getCardLogo()
	{
		return cardLogo;
	}

	public void setCardLogo(String cardLogo)
	{
		this.cardLogo = cardLogo;
	}

	public String getCardCode()
	{
		return cardCode;
	}

	public void setCardCode(String cardCode)
	{
		this.cardCode = cardCode;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getSubbranch()
	{
		return subbranch;
	}

	public void setSubbranch(String subbranch)
	{
		this.subbranch = subbranch;
	}

}

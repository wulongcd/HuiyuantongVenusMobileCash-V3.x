package com.sintn.hera.mobile.cash.entity.down;

/**
 * 收款宝->提现账户下行实体
 */
public class BindingBankCardForCashierAppDown
{
	// 提现账户ID
	private long id;
	
	// 银行名称
	private String bankName;
	
	// 银行logo，图片文件名称，带后缀，为空
	private String logo;
	
	// 银行卡卡号
	private String cardCode;
	
	// 账户名称
	private String accountName;
	
	// 省
	private String province;
	
	// 市
	private String city;
	
	// 支行
	private String subbranch;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getLogo()
	{
		return logo;
	}

	public void setLogo(String logo)
	{
		this.logo = logo;
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

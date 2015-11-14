package com.sintn.hera.mobile.cash.entity.up;

/**
 * 收款宝->提现账户的上行实体
 */
public class BindingBankCardForCashierAppUp
{
	// 银行名称，必填，1-32个字符组成，不能包含特殊字符，包含在数据库的银行列表中
	private String bankName;
	
	// 银行卡卡号，必填，1-32个字符组成，不能包含特殊字符，一般19位
	private String cardCode;
	
	// 账户名称，必填，1-32个字符组成，不能包含特殊字符
	private String accountName;
	
	// 省，必填，1-16个字符组成，不能包含特殊字符
	private String province;
	
	// 市，必填，1-16个字符组成，不能包含特殊字符
	private String city;
	
	// 支行，必填，1-32个字符组成，不能包含特殊字符
	private String subbranch;

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
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

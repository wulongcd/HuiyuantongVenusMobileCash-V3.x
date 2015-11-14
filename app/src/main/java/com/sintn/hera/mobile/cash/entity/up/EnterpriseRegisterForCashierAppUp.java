package com.sintn.hera.mobile.cash.entity.up;

import java.util.List;

/**
 * 收款宝->企业注册信息的上行实体
 */
public class EnterpriseRegisterForCashierAppUp
{
	// 企业名称，必填，1-14个字符组成，不能包含特殊字符
	private String name;
	
	// 一级行业ID，必填
	private long category1Id;
	
	// 二级行业ID列表，必填，至少一个
	private List<Long> category2Ids;
	
	// 企业地址，必填，1-50个字符组成，不能包含特殊字符
	private String address;
	
	// 手机号码，必填
	private String phone;
	
	// 验证码，必填
	private String code;
	
	// 企业账号（企业超级管理员账号，店铺收银老板账号），必填，6-16个字符组成，不能包含特殊字符
	private String username;
	
	// 密码，必填，6-16个字母和数字的组合
	private String password;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getCategory1Id()
	{
		return category1Id;
	}

	public void setCategory1Id(long category1Id)
	{
		this.category1Id = category1Id;
	}

	public List<Long> getCategory2Ids()
	{
		return category2Ids;
	}

	public void setCategory2Ids(List<Long> category2Ids)
	{
		this.category2Ids = category2Ids;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
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

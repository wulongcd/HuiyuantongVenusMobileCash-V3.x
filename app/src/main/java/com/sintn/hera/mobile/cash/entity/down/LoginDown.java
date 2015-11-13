package com.sintn.hera.mobile.cash.entity.down;

import java.io.Serializable;

/**
 * 
 * @Desc: 登录的上行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-8-4下午6:02:49
 */
@SuppressWarnings("serial")
public class LoginDown implements Serializable
{

	//账号ID
	private long id;
	
	//企业名称
	private String enterpriseName;
	
	//店铺名称
	private String shopName;

	public LoginDown()
	{
		super();
	}

	public LoginDown(long id, String enterpriseName, String shopName)
	{
		super();
		this.id = id;
		this.enterpriseName = enterpriseName;
		this.shopName = shopName;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getEnterpriseName()
	{
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName)
	{
		this.enterpriseName = enterpriseName;
	}

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

}

package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 企业店铺的下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @EnterpriseShopDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-30上午11:41:13
 */
public class EnterpriseShopDown
{
	/**
	 * 店铺ID
	 * 
	 */
	private long id;

	/**
	 * 店铺名称
	 * 
	 */
	private String name;

	public EnterpriseShopDown()
	{
		super();
	}

	public EnterpriseShopDown(long id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return this.name;
	}
}

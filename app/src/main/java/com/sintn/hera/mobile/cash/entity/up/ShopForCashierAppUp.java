package com.sintn.hera.mobile.cash.entity.up;

/**
 * 收款宝->店铺信息的上行实体
 */
public class ShopForCashierAppUp
{
	// 店铺ID，创建时不填，更新时必填
	private long shopId;
	
	// 店铺编号，必填，1-6个字符组成，不能包含特殊字符
	private String code;
	
	// 店铺名称，必填，1-16个字符组成，不能包含特殊字符
	private String name;
	
	// 店铺电话，必填，符合电话格式
	private String phone;
	
	// 省Code，必填，不是ID
	private long provinceCode;
	
	// 市Code，必填，不是ID
	private long cityCode;
	
	// 区Code，必填，不是ID
	private long areaCode;
	
	// 店铺地址，必填，1-50个字符组成，不能包含特殊字符
	private String address;

	public long getShopId()
	{
		return shopId;
	}

	public void setShopId(long shopId)
	{
		this.shopId = shopId;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public long getProvinceCode()
	{
		return provinceCode;
	}

	public void setProvinceCode(long provinceCode)
	{
		this.provinceCode = provinceCode;
	}

	public long getCityCode()
	{
		return cityCode;
	}

	public void setCityCode(long cityCode)
	{
		this.cityCode = cityCode;
	}

	public long getAreaCode()
	{
		return areaCode;
	}

	public void setAreaCode(long areaCode)
	{
		this.areaCode = areaCode;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
}

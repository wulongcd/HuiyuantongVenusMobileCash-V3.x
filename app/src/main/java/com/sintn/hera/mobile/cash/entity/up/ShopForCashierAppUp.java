package com.sintn.hera.mobile.cash.entity.up;

/**
 * 收款宝->店铺信息的上行实体
 */
public class ShopForCashierAppUp
{
	// 店铺ID，创建时不填，更新时必填
	private long shopId;
	
	// 店铺编号，必填，1-14个字符组成，不能包含特殊字符
	private String code;
	
	// 店铺名称，必填，1-14个字符组成，不能包含特殊字符
	private String name;
	
	// 店铺电话，必填，符合电话格式
	private String phone;
	
	// 省ID，必填
	private long provinceId;
	
	// 市ID，必填
	private long cityId;
	
	// 区ID，必填
	private long areaId;
	
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

	public long getProvinceId()
	{
		return provinceId;
	}

	public void setProvinceId(long provinceId)
	{
		this.provinceId = provinceId;
	}

	public long getCityId()
	{
		return cityId;
	}

	public void setCityId(long cityId)
	{
		this.cityId = cityId;
	}

	public long getAreaId()
	{
		return areaId;
	}

	public void setAreaId(long areaId)
	{
		this.areaId = areaId;
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

package com.sintn.hera.mobile.cash.entity.down;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 收款宝->店铺信息的下行实体
 */
public class ShopForCashierAppDown implements Parcelable {
	// 店铺ID
	private long id;
	
	// 店铺编号
	private String code;
	
	// 店铺名称
	private String name;
	
	// 店铺电话
	private String phone;
	
	// 省
	private String province;
	
	// 市
	private String city;
	
	// 区
	private String area;
	
	// 地址
	private String address;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
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

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(this.id);
		dest.writeString(this.code);
		dest.writeString(this.name);
		dest.writeString(this.phone);
		dest.writeString(this.province);
		dest.writeString(this.city);
		dest.writeString(this.area);
		dest.writeString(this.address);
	}

	public ShopForCashierAppDown() {
	}

	protected ShopForCashierAppDown(Parcel in) {
		this.id = in.readLong();
		this.code = in.readString();
		this.name = in.readString();
		this.phone = in.readString();
		this.province = in.readString();
		this.city = in.readString();
		this.area = in.readString();
		this.address = in.readString();
	}

	public static final Parcelable.Creator<ShopForCashierAppDown> CREATOR = new Parcelable.Creator<ShopForCashierAppDown>() {
		public ShopForCashierAppDown createFromParcel(Parcel source) {
			return new ShopForCashierAppDown(source);
		}

		public ShopForCashierAppDown[] newArray(int size) {
			return new ShopForCashierAppDown[size];
		}
	};
}

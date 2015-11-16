package com.sintn.hera.mobile.cash.entity.down;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 收款宝->店铺管理员账户（收银员）的下行实体
 */
public class ShopManagerAccountForCashierAppDown implements Parcelable {
	// 店铺管理员账户ID，创建时不填，更新时必填
	private long id;
	
	// 店铺管理员名称，必填，
	private String name;
	
	// 店铺管理员账号，必填
	private String username;
	
	// 店铺管理员密码，必填
	private String password;

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(this.id);
		dest.writeString(this.name);
		dest.writeString(this.username);
		dest.writeString(this.password);
	}

	public ShopManagerAccountForCashierAppDown() {
	}

	protected ShopManagerAccountForCashierAppDown(Parcel in) {
		this.id = in.readLong();
		this.name = in.readString();
		this.username = in.readString();
		this.password = in.readString();
	}

	public static final Parcelable.Creator<ShopManagerAccountForCashierAppDown> CREATOR = new Parcelable.Creator<ShopManagerAccountForCashierAppDown>() {
		public ShopManagerAccountForCashierAppDown createFromParcel(Parcel source) {
			return new ShopManagerAccountForCashierAppDown(source);
		}

		public ShopManagerAccountForCashierAppDown[] newArray(int size) {
			return new ShopManagerAccountForCashierAppDown[size];
		}
	};
}

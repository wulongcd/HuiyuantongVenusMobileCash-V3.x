package com.sintn.hera.mobile.cash.entity.down;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 收款宝->地区的下行实体
 */
public class RegionForCashierAppDown implements Parcelable {
	// 地区ID
	private long id;
	
	// 编号
	private String code;
	
	// 名称
	private String name;

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(this.id);
		dest.writeString(this.code);
		dest.writeString(this.name);
	}

	public RegionForCashierAppDown() {
	}

	protected RegionForCashierAppDown(Parcel in) {
		this.id = in.readLong();
		this.code = in.readString();
		this.name = in.readString();
	}

	public static final Parcelable.Creator<RegionForCashierAppDown> CREATOR = new Parcelable.Creator<RegionForCashierAppDown>() {
		public RegionForCashierAppDown createFromParcel(Parcel source) {
			return new RegionForCashierAppDown(source);
		}

		public RegionForCashierAppDown[] newArray(int size) {
			return new RegionForCashierAppDown[size];
		}
	};
}

package com.sintn.hera.mobile.cash.entity.down;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 收款宝->行业的下行实体
 */
public class CategoryForCashierAppDown implements Parcelable {
	// 行业ID
	private long id;
	
	// 行业名称
	private String name;

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
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(this.id);
		dest.writeString(this.name);
	}

	public CategoryForCashierAppDown() {
	}

	protected CategoryForCashierAppDown(Parcel in) {
		this.id = in.readLong();
		this.name = in.readString();
	}

	public static final Parcelable.Creator<CategoryForCashierAppDown> CREATOR = new Parcelable.Creator<CategoryForCashierAppDown>() {
		public CategoryForCashierAppDown createFromParcel(Parcel source) {
			return new CategoryForCashierAppDown(source);
		}

		public CategoryForCashierAppDown[] newArray(int size) {
			return new CategoryForCashierAppDown[size];
		}
	};
}

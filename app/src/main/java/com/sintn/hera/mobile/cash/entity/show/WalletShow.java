package com.sintn.hera.mobile.cash.entity.show;

public class WalletShow
{
	private String desc;

	public WalletShow(String desc)
	{
		super();
		this.desc = desc;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return this.desc;
	}
}

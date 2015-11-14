package com.sintn.hera.mobile.cash.entity.show;

public class RankTypeShow
{
	private int type;
	private String desc;

	public RankTypeShow(int type, String desc)
	{
		super();
		this.type = type;
		this.desc = desc;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
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

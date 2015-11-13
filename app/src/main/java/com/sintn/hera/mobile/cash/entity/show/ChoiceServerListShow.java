package com.sintn.hera.mobile.cash.entity.show;

public class ChoiceServerListShow
{
	private String desc;
	private int position;

	public ChoiceServerListShow(String desc)
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

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return this.desc;
	}
}

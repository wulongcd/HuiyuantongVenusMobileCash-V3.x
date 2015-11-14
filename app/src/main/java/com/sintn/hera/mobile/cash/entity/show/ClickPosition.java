package com.sintn.hera.mobile.cash.entity.show;

/**
 * 
 * @com.sintn.hera.mobile.cash.entity.show
 * @HuiyuantongVenusShopCash-V3.x
 * @ClickPosition.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 点击位置
 * @2015-3-2上午9:49:39
 */
public class ClickPosition
{

	public final static int NO_CHILDPOSITION = -1;

	private int groupPosition;
	private int childPosition;

	public ClickPosition(int groupPosition, int childPosition)
	{
		this.groupPosition = groupPosition;
		this.childPosition = childPosition;
	}

	public int getGroupPosition()
	{
		return groupPosition;
	}

	public void setGroupPosition(int groupPosition)
	{
		this.groupPosition = groupPosition;
	}

	public int getChildPosition()
	{
		return childPosition;
	}

	public void setChildPosition(int childPosition)
	{
		this.childPosition = childPosition;
	}
}

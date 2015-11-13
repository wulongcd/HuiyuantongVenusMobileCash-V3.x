package com.sintn.hera.mobile.cash.entity.show;

public class MyselfListShow
{
	/**
	 * 左侧文字
	 */
	private String leftTitle;
	/**
	 * 头像路径
	 */
	private String imageUrl;
	/**
	 * 右侧文字
	 */
	private String rightTitle;
	/**
	 * 位置
	 */
	private int position;

	public MyselfListShow(String leftTitle, String imageUrl, String rightTitle, int position)
	{
		super();
		this.leftTitle = leftTitle;
		this.imageUrl = imageUrl;
		this.rightTitle = rightTitle;
		this.position = position;
	}

	public String getLeftTitle()
	{
		return leftTitle;
	}

	public void setLeftTitle(String leftTitle)
	{
		this.leftTitle = leftTitle;
	}

	public String getImageUrl()
	{
		return imageUrl;
	}

	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}

	public String getRightTitle()
	{
		return rightTitle;
	}

	public void setRightTitle(String rightTitle)
	{
		this.rightTitle = rightTitle;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

}

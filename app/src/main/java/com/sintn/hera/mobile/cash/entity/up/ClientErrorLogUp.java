package com.sintn.hera.mobile.cash.entity.up;

/**
 * 
 * @com.sintn.hera.shop.entity.up
 * @HuiyuantongVenusShopCash-V3.x
 * @ClientErrorLogUp.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 客户端错误日志的上行实体
 * @2015-5-5上午11:22:07
 */
public class ClientErrorLogUp
{
	/**
	 * 错误的内容
	 */
	private String content;

	public ClientErrorLogUp(String content)
	{
		super();
		this.content = content;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}

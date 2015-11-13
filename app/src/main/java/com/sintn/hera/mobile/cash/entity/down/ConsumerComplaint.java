package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 顾客投诉
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @ConsumerComplaint.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-2上午9:36:54
 */
public class ConsumerComplaint
{
	// 消费者ID
	private long consumerId;

	// 消费者的名称
	private String consumerName;

	// 消费者的电话
	private String consumerPhone;

	// 企业ID
	private long enterpriseId;

	// 企业名称
	private String enterpriseName;

	// 店铺ID
	private long shopId;

	// 店铺名称
	private String shopName;

	// 内容
	private String content;

	public long getConsumerId()
	{
		return consumerId;
	}

	public void setConsumerId(long consumerId)
	{
		this.consumerId = consumerId;
	}

	public String getConsumerName()
	{
		return consumerName;
	}

	public void setConsumerName(String consumerName)
	{
		this.consumerName = consumerName;
	}

	public String getConsumerPhone()
	{
		return consumerPhone;
	}

	public void setConsumerPhone(String consumerPhone)
	{
		this.consumerPhone = consumerPhone;
	}

	public long getEnterpriseId()
	{
		return enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId)
	{
		this.enterpriseId = enterpriseId;
	}

	public String getEnterpriseName()
	{
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName)
	{
		this.enterpriseName = enterpriseName;
	}

	public long getShopId()
	{
		return shopId;
	}

	public void setShopId(long shopId)
	{
		this.shopId = shopId;
	}

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
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

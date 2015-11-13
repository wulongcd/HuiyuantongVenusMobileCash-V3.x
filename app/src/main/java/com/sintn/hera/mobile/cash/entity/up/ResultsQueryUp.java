package com.sintn.hera.mobile.cash.entity.up;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Desc: 业绩的查询条件
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @ResultsQueryUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:06:02
 */
@SuppressWarnings("serial")
public class ResultsQueryUp implements Serializable
{
	// 店铺ID，为0表示所有店铺
	private long shopId;

	// 开始时间
	private Date beginDate;

	// 结束时间
	private Date endDate;

	public ResultsQueryUp(long shopId, Date beginDate, Date endDate)
	{
		super();
		this.shopId = shopId;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public long getShopId()
	{
		return shopId;
	}

	public void setShopId(long shopId)
	{
		this.shopId = shopId;
	}

	public Date getBeginDate()
	{
		return beginDate;
	}

	public void setBeginDate(Date beginDate)
	{
		this.beginDate = beginDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
}

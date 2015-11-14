package com.sintn.hera.mobile.cash.entity.up;

import java.util.Date;

/**
 * 
 * @Desc: 店铺排行的查询条件
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @RankQueryUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:05:38
 */
public class RankQueryUp
{
	// 排行内容，参见RankType类
	private int rankType;

	// 开始时间
	private Date beginDate;

	// 结束时间
	private Date endDate;

	public RankQueryUp(int rankType, Date beginDate, Date endDate)
	{
		super();
		this.rankType = rankType;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public int getRankType()
	{
		return rankType;
	}

	public void setRankType(int rankType)
	{
		this.rankType = rankType;
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

package com.sintn.hera.mobile.cash.entity.up;

import java.util.Date;

/**
 * 
 * @Desc: 在线支付或提现订单的查询条件
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @OnlinePayOrWithdrawOrderQueryUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-10下午3:50:08
 */
public class OnlinePayOrWithdrawOrderQueryUp
{
	// 页索引
	protected int page;

	// 每页显示最多条数
	protected int size;

	// 排序字段
	protected String sortField;

	// 排序类型
	protected int sortType;
	// 开始时间
	private Date beginDate;

	// 介绍时间
	private Date endDate;

	public OnlinePayOrWithdrawOrderQueryUp(int page, int size, String sortField, int sortType, Date beginDate, Date endDate)
	{
		super();
		this.page = page;
		this.size = size;
		this.sortField = sortField;
		this.sortType = sortType;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public String getSortField()
	{
		return sortField;
	}

	public void setSortField(String sortField)
	{
		this.sortField = sortField;
	}

	public int getSortType()
	{
		return sortType;
	}

	public void setSortType(int sortType)
	{
		this.sortType = sortType;
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

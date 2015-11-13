package com.sintn.hera.mobile.cash.entity.up;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Desc: 通知（投诉、消息）的查询条件
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @NotificationForEnterpriseQueryUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:05:04
 */
@SuppressWarnings("serial")
public class NotificationForEnterpriseQueryUp implements Serializable
{
	// 匹配通知内容的字符串
	private String name;

	// 通知类型，参见NotificationType类
	private int type;

	// 开始时间
	private Date beginDate;

	// 结束时间
	private Date endDate;
	// 页索引
	protected int page;

	// 每页显示最多条数
	protected int size;

	// 排序字段
	protected String sortField;

	// 排序类型
	protected int sortType;

	public NotificationForEnterpriseQueryUp(String name, int type, Date beginDate, Date endDate, int page, int size, String sortField, int sortType)
	{
		super();
		this.name = name;
		this.type = type;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.page = page;
		this.size = size;
		this.sortField = sortField;
		this.sortType = sortType;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
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

}

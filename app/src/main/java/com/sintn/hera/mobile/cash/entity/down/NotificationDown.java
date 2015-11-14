package com.sintn.hera.mobile.cash.entity.down;

import java.util.List;

public class NotificationDown
{
	/**
	 * 总计条数
	 */
	private int totalCount;

	/**
	 * 查询结果列表
	 */
	private List<EnterpriseNotificationDown> list;

	public NotificationDown()
	{
		super();
	}

	public NotificationDown(int totalCount, List<EnterpriseNotificationDown> list)
	{
		super();
		this.totalCount = totalCount;
		this.list = list;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public List<EnterpriseNotificationDown> getList()
	{
		return list;
	}

	public void setList(List<EnterpriseNotificationDown> list)
	{
		this.list = list;
	}

}

package com.sintn.hera.mobile.cash.entity.down;

import java.util.List;

/**
 * 分页查询下行实体
 */
public class CommonPagerDown <T>
{
	// 总计条数
	private int totalCount;
	
	// 查询结果列表
	private List<T> list;

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public List<T> getList()
	{
		return list;
	}

	public void setList(List<T> list)
	{
		this.list = list;
	}
}

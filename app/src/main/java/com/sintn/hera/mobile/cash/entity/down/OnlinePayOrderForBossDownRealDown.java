package com.sintn.hera.mobile.cash.entity.down;

import java.util.List;

public class OnlinePayOrderForBossDownRealDown
{
	// 总计条数
	private int totalCount;

	// 查询结果列表
	private List<OnlinePayOrderForBossDown> list;

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public List<OnlinePayOrderForBossDown> getList()
	{
		return list;
	}

	public void setList(List<OnlinePayOrderForBossDown> list)
	{
		this.list = list;
	}

}

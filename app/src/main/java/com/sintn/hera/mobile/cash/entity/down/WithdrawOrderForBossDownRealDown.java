package com.sintn.hera.mobile.cash.entity.down;

import java.util.List;

public class WithdrawOrderForBossDownRealDown
{
	// 总计条数
	private int totalCount;

	// 查询结果列表
	private List<WithdrawOrderForBossDown> list;

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	public List<WithdrawOrderForBossDown> getList()
	{
		return list;
	}

	public void setList(List<WithdrawOrderForBossDown> list)
	{
		this.list = list;
	}

}

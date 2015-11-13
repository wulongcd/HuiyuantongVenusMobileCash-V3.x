package com.sintn.hera.mobile.cash.entity.down;

import java.util.List;

public class PagerDown<T>
{
	/**
	 * 总记录数
	 */
	private long total;
	/**
	 * 分页的数据
	 */
	private List<T> datas;
	
	public PagerDown()
	{
	}

	public long getTotal()
	{
		return total;
	}

	public void setTotal(long total)
	{
		this.total = total;
	}

	public List<T> getDatas()
	{
		return datas;
	}

	public void setDatas(List<T> datas)
	{
		this.datas = datas;
	}

}

package com.sintn.hera.mobile.cash.entity.up;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class PerformanceUp implements Serializable
{

	//开始时间
	private Date startDate;
	
	//结束时间
	private Date endDate;

	public PerformanceUp()
	{
	}

	public PerformanceUp(Date startDate, Date endDate)
	{
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
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

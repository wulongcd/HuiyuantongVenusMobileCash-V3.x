package com.sintn.hera.mobile.cash.entity.down;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class DividedStaffDown
{

	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	//业绩
	private double performance;
	
	//提成金额
	private double income;

	//提成详情ID
	private long id;

	public DividedStaffDown()
	{
	}

	public DividedStaffDown(Date createDate, double performance, double income, long id)
	{
		super();
		this.createDate = createDate;
		this.performance = performance;
		this.income = income;
		this.id = id;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public double getPerformance()
	{
		return performance;
	}

	public void setPerformance(double performance)
	{
		this.performance = performance;
	}

	public double getIncome()
	{
		return income;
	}

	public void setIncome(double income)
	{
		this.income = income;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
	
}



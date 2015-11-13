package com.sintn.hera.mobile.cash.entity.up;

import java.util.Date;


/**
 * 简单收银->收银流水的查询条件
 */
public class OrderForSimpleCashierQueryUp
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
	
	// 结束时间
	private Date endDate;
	
	// 在线支付方式，参见OnlinePaymentType类
	private int paymentType;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}

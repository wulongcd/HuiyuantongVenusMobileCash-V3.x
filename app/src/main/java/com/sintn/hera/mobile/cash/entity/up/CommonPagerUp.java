package com.sintn.hera.mobile.cash.entity.up;


/**
 * 分页查询条件
 */ 
public class CommonPagerUp
{
	// 页索引
	protected int page;
	
	// 每页显示最多条数
	protected int size;
	
	// 排序字段
	protected String sortField;
	
	// 排序类型
	protected int sortType;
	
	public CommonPagerUp()
	{
		
	}
	
	public CommonPagerUp(int page, int size, String sortField, int sortType)
	{
		this.page = page;
		this.size = size;
		this.sortField = sortField;
		this.sortType = sortType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
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
}

package com.sintn.hera.mobile.cash.entity.show;

import com.sintn.hera.mobile.cash.entity.down.SaleStatisDown;

public class StatisticListShow
{
	private SaleStatisDown left;
	private SaleStatisDown right;
	
	public StatisticListShow()
	{
		super();
	}

	public SaleStatisDown getLeft()
	{
		return left;
	}

	public void setLeft(SaleStatisDown left)
	{
		this.left = left;
	}

	public SaleStatisDown getRight()
	{
		return right;
	}

	public void setRight(SaleStatisDown right)
	{
		this.right = right;
	}

}

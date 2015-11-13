package com.sintn.hera.mobile.cash.adapter;

import com.sintn.hera.mobile.cash.listener.OnListViewChildViewClickListener;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 * @Desc: 基础子ItemView点击事件
 * @com.sintn.hera.mobile.cash.adapter
 * @HuiyuantongVenusMobileCash-V3.x
 * @SetBaseChildViewClickAbleAdapter.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:19:10
 */

public abstract class MobileCashBaseChildViewClickAbleAdapter<E extends Object> extends MobileCashBaseAdapter<E> implements OnClickListener
{

	private OnListViewChildViewClickListener onListViewChildViewClickListener;

	public void setOnListViewChildViewClickListener(OnListViewChildViewClickListener onListViewChildViewClickListener)
	{
		this.onListViewChildViewClickListener = onListViewChildViewClickListener;
	}

	@Override
	public void onClick(View v)
	{
		onListViewChildViewClickListener.onListChildViewClicked(v, v.getTag());
	}

}

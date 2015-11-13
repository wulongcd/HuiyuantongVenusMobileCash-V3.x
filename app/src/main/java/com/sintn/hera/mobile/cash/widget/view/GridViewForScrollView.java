package com.sintn.hera.mobile.cash.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 
 * @com.sintn.hera.mobile.cash.widget.view
 * @HuiyuantongVenusShopCash-V3.x
 * @MyGridView.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: TODO
 * @2015-2-12上午11:40:20
 */

public class GridViewForScrollView extends GridView
{

	public GridViewForScrollView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public GridViewForScrollView(Context context)
	{
		super(context);
	}

	public GridViewForScrollView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}

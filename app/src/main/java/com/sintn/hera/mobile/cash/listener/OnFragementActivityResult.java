package com.sintn.hera.mobile.cash.listener;

import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;

import android.view.View;
import android.widget.AdapterView;

/**
 * 
 * @com.sintn.hera.mobile.cash.listener
 * @HuiyuantongVenusShopCash-V3.x
 * @OnFragementActivityResult.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: TODO
 * @2015-2-14上午9:33:48
 */
public interface OnFragementActivityResult
{
	public void onClick(View view, int clickedViewId);

	public void onEventRunEnd(MobileCashBaseEvent event, int eventCode);

	public void onItemClick(AdapterView<?> parent, View view, int position, long id);

	public void onListChildViewClicked(View view, Object object);

	public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id);

	public void onTabChanged(String tabId);
}

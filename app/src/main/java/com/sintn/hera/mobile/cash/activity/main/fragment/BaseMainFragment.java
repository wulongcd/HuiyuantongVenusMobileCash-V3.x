package com.sintn.hera.mobile.cash.activity.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sintn.hera.mobile.cash.activity.fragment.BaseFragment;
import com.sintn.hera.mobile.cash.activity.main.MainActivity;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.utils.core.EventManager.OnEventListener;
import com.sintn.hera.mobile.cash.widget.view.xlistview.XListView.IXListViewListener;

public class BaseMainFragment extends BaseFragment implements IXListViewListener, OnEventListener
{
	/**
	 * activity上下文
	 */
	protected MainActivity mainActivity = null;


	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		mainActivity = (MainActivity) getActivity();
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		super.onClick(v);
	}

	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
	}

	@Override
	public void onRefresh()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoadMore()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		mainActivity = null;
		eventCode = 0;
		super.onDestroy();
	}
	
//	@Override
//	public void onResume()
//	{
//		this.onRefresh();
//		super.onResume();
//	}
	
	@Override
	public void onTabChanged(String tabId)
	{
		// 通过反射确认fragment类名，并根据类名所在fragment刷新界面
		String className = this.getClass().getName();
		if(className.equals(tabId)) {
			this.onRefresh();
		}
	}

//	//获取当前日期
//	@SuppressLint("SimpleDateFormat")
//	public String getNowTime()
//	{
//		Calendar calendar = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		calendar.setTimeInMillis(System.currentTimeMillis());
//		String nowTime = sdf.format(calendar.getTime());
//		return nowTime;
//	}
	
}

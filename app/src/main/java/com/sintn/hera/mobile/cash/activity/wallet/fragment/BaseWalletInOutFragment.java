package com.sintn.hera.mobile.cash.activity.wallet.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sintn.hera.assistant.activity.fragment.BaseFragment;
import com.sintn.hera.assistant.activity.main.wallet.WalletInOutRecordsActivty;
import com.sintn.hera.assistant.event.BossAssistantBaseEvent;
import com.sintn.hera.assistant.utils.core.EventManager.OnEventListener;
import com.sintn.hera.assistant.widget.view.xlistview.XListView.IXListViewListener;

public class BaseWalletInOutFragment extends BaseFragment implements IXListViewListener, OnEventListener
{
	/**
	 * activity上下文
	 */
	protected WalletInOutRecordsActivty walletInOutRecordsActivty = null;
	/**
	 * 
	 */
	protected int clickViewId = -1;

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
		walletInOutRecordsActivty = (WalletInOutRecordsActivty) getActivity();
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		super.onClick(v);
		clickViewId = v.getId();
	}

	@Override
	public void onEventRunEnd(BossAssistantBaseEvent event)
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
		walletInOutRecordsActivty = null;
		eventCode = 0;
		super.onDestroy();
	}
}

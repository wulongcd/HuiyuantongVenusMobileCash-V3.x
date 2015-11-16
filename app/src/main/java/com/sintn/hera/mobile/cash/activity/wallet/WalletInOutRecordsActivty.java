package com.sintn.hera.mobile.cash.activity.wallet;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

import com.sintn.hera.assistant.R;
import com.sintn.hera.assistant.activity.base.BaseActivity;
import com.sintn.hera.assistant.activity.main.wallet.fragment.WalletIn;
import com.sintn.hera.assistant.activity.main.wallet.fragment.WalletOut;
import com.sintn.hera.assistant.event.BossAssistantBaseEvent;
import com.sintn.hera.assistant.listener.OnFragementActivityResult;
import com.sintn.hera.assistant.manager.ActivityBaseAttribute;
import com.sintn.hera.assistant.utils.common.CommonUtils;

@SuppressLint("InflateParams")
public class WalletInOutRecordsActivty extends BaseActivity implements OnTabChangeListener
{
	/**
	 * 
	 */
	private List<OnFragementActivityResult> onFragementActivityResults = new ArrayList<OnFragementActivityResult>();
	/**
	 * 用于释放tab的实体类对象
	 */
	private TabHost tabHost;

	public void addOnFragementActivityResult(OnFragementActivityResult onFragementActivityResult, int index)
	{
		this.onFragementActivityResults.add(index, onFragementActivityResult);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void OnInitUiAndData()
	{
		// TODO Auto-generated method stub
		super.OnInitUiAndData();
		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setOnTabChangedListener(this);
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
		initTab();
	}

	@Override
	public void onEventRunEnd(BossAssistantBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
	}

	private void initTab()
	{
		// 收入
		addTab(WalletIn.class.getName(), R.string.tab_title_of_walltin, R.id.WalletIn);
		// 提现
		addTab(WalletOut.class.getName(), R.string.tab_title_of_walltout, R.id.WalletOut);
	}

	/**
	 * 添加tab
	 * 
	 * @param strTag
	 * @param textResId
	 * @param viewId
	 */
	private void addTab(String strTag, int textResId, int viewId)
	{
		tabHost.setup();
		final TabHost.TabSpec tabSpec = tabHost.newTabSpec(strTag);
		final View view = LayoutInflater.from(this).inflate(R.layout.mainactivity_layout_of_tab_item, null);
		final ImageView iv = (ImageView) view.findViewById(R.id.tab_icon);
		switch (viewId)
		{
		case R.id.WalletIn:
			iv.setImageResource(R.drawable.selector_in_mainactivity_of_performance);
			break;
		case R.id.WalletOut:
			iv.setImageResource(R.drawable.selector_in_mainactivity_of_shop);
			break;
		default:
			break;
		}
		final TextView tv = (TextView) view.findViewById(R.id.tab_text);
		tv.setText(textResId);
		tabSpec.setIndicator(view).setContent(viewId);
		tabHost.addTab(tabSpec);
	}

	@Override
	public void onTabChanged(String tabId)
	{
		for (OnFragementActivityResult onFragementActivityResult : onFragementActivityResults)
		{
			onFragementActivityResult.onTabChanged(tabId);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// TODO Auto-generated method stub
		super.onItemClick(parent, view, position, id);
	}

	@Override
	public void onListChildViewClicked(View view, Object object)
	{
		// TODO Auto-generated method stub
		super.onListChildViewClicked(view, object);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		super.onClick(v);
	}

	@Override
	protected void onInitAttribute(ActivityBaseAttribute ba)
	{
		super.onInitAttribute(ba);
		ba.setHasBackButton(true);
		ba.setNavigationBarBackground(getResources().getColor(R.color.cf0f0f0));
		ba.setTextViewInNavigationBarStringId(R.string.man_walletinoutrecordsactivty_show);
		ba.setTextViewInNavigationBarColor(Color.BLACK);
		ba.setHasImageViewCtener(false);
	}

	public static void launch(Activity activity)
	{
		if (!CommonUtils.isActivityAreRunningBefore(activity, WalletInOutRecordsActivty.class))
		{
			Intent intent = new Intent(activity, WalletInOutRecordsActivty.class);
			activity.startActivity(intent);
		}
	}

	@Override
	public void onBackPressed()
	{
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}

}

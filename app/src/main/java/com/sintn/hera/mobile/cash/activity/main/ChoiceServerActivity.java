package com.sintn.hera.mobile.cash.activity.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.activity.login.LoginActivity;
import com.sintn.hera.mobile.cash.adapter.ChoiceServerActivityListAdapter;
import com.sintn.hera.mobile.cash.entity.show.ChoiceServerListShow;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.R;

/**
 * 
 * @Desc: 选择服务器
 * @com.sintn.hera.mobile.cash.activity.main
 * @HuiyuantongVenusMobileCash-V3.x
 * @ChoiceServerActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-8下午2:11:12
 */
public class ChoiceServerActivity extends BaseActivity
{
	ListView lv_in_choiceserveractivity_for_lists = null;
	ChoiceServerActivityListAdapter<ChoiceServerListShow> choiceServerActivityListAdapterChoiceServerListShow = null;

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
		lv_in_choiceserveractivity_for_lists = (ListView) findViewById(R.id.lv_in_choiceserveractivity_for_lists);
		lv_in_choiceserveractivity_for_lists.setOnItemClickListener(this);
		choiceServerActivityListAdapterChoiceServerListShow = new ChoiceServerActivityListAdapter<ChoiceServerListShow>(mContext);
		choiceServerActivityListAdapterChoiceServerListShow.addItem(new ChoiceServerListShow("https://sintn.com"));
		choiceServerActivityListAdapterChoiceServerListShow.addItem(new ChoiceServerListShow("http://115.29.166.91"));
		choiceServerActivityListAdapterChoiceServerListShow.addItem(new ChoiceServerListShow("http://121.40.75.81"));
		String myLocIp = getLocalIpAddress2(BaseApplication.getApplication());
		myLocIp = myLocIp.substring(0, myLocIp.indexOf("-"));
		for (int i = 0; i < 255; i++)
		{
			choiceServerActivityListAdapterChoiceServerListShow.addItem(new ChoiceServerListShow("http://" + myLocIp + "." + i + ":8080"));
		}
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
		lv_in_choiceserveractivity_for_lists.setAdapter(choiceServerActivityListAdapterChoiceServerListShow);
	}

	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		super.onClick(v);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// TODO Auto-generated method stub
		super.onItemClick(parent, view, position, id);
		Object object = parent.getItemAtPosition(position);
		if (object != null)
		{
			if (object instanceof ChoiceServerListShow)
			{
				ChoiceServerListShow c = (ChoiceServerListShow) object;
//				AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.CALLBACK_OF_CHOICESERVER_OK), 0, c.getDesc());
				URLUtils.initURServer(c.getDesc());

				if(BaseApplication.isLogined()) {
					MainActivity.launch(this);
				}else {
					LoginActivity.launch(this);
				}
				finish();
			}
		}
	}

	@Override
	protected void onInitAttribute(ActivityBaseAttribute ba)
	{
		super.onInitAttribute(ba);
		ba.setHasBackButton(false);
		ba.setNavigationBarBackground(getResources().getColor(R.color.cf0f0f0));
		ba.setTextViewInNavigationBarStringId(R.string.man_chioceserveractivity_show);
		ba.setTextViewInNavigationBarColor(Color.BLACK);
		ba.setHasImageViewCtener(false);
	}

	public static void launch(Activity activity)
	{
		if (!CommonUtils.isActivityAreRunningBefore(activity, ChoiceServerActivity.class))
		{
			Intent intent = new Intent(activity, ChoiceServerActivity.class);
			activity.startActivity(intent);
			activity.finish();
		}
	}
	
	/**
	 * 获取本机IP
	 * 
	 * @param context
	 * @return
	 */
	public static String getLocalIpAddress2(Context context)
	{
		// 获取wifi服务
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		// 判断wifi是否开启
		if (!wifiManager.isWifiEnabled())
		{
			wifiManager.setWifiEnabled(true);
		}
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		int ipAddress = wifiInfo.getIpAddress();
		String ip = intToIp(ipAddress);
		return ip;
	}

	/**
	 * 数字IP地址转换为字符串IP地址
	 * 
	 * @param i
	 * 
	 * @return
	 */
	private static String intToIp(int i)
	{
		return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "-" + (i >> 24 & 0xFF);
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

package com.sintn.hera.mobile.cash.activity.wallet.fragment;

import java.util.Date;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.sintn.hera.assistant.EventCode;
import com.sintn.hera.assistant.R;
import com.sintn.hera.assistant.URLUtils;
import com.sintn.hera.assistant.activity.main.ComplaintDetailsActivty;
import com.sintn.hera.assistant.adapter.fragment.WalletInAdapter;
import com.sintn.hera.assistant.entity.conast.SortType;
import com.sintn.hera.assistant.entity.down.EnterpriseNotificationDown;
import com.sintn.hera.assistant.entity.down.ErrorObject;
import com.sintn.hera.assistant.entity.down.OnlinePayOrderForBossDown;
import com.sintn.hera.assistant.entity.up.OnlinePayOrWithdrawOrderQueryUp;
import com.sintn.hera.assistant.event.BossAssistantBaseCallbackEvent;
import com.sintn.hera.assistant.event.BossAssistantBaseEvent;
import com.sintn.hera.assistant.event.httpevent.main.QueryOnlinePayOrWithdrawOrderResultsEvent;
import com.sintn.hera.assistant.listener.OnListViewChildViewClickListener;
import com.sintn.hera.assistant.manager.AndroidEventManager;
import com.sintn.hera.assistant.utils.common.DateUtil;
import com.sintn.hera.assistant.utils.common.DialogUtils;
import com.sintn.hera.assistant.utils.common.ToastManager;
import com.sintn.hera.assistant.widget.view.xlistview.XListView;

/**
 * 
 * @Desc: 钱包收入记录
 * @com.sintn.hera.assistant.activity.main.fragment
 * @HuiyuantongVenusBossAssistant-V3.x
 * @Performance.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午4:28:35
 */

public class WalletIn extends BaseWalletInOutFragment implements OnListViewChildViewClickListener, OnClickListener
{

	private OnlinePayOrWithdrawOrderQueryUp onlinePayOrWithdrawOrderQueryUp = null;
	@SuppressWarnings("unused")
	private boolean isQueryFirstOK = false;
	private ViewGroup vg_in_fragment_of_walletin_for_root = null;// 根视图
	private Button btn_in_fragment_of_walletin_for_date_start = null;// 开始时间
	private Button btn_in_fragment_of_walletin_for_date_end = null;// 结束时间
	private XListView xlv_in_fragment_of_walletin_for_lists = null;
	private WalletInAdapter<OnlinePayOrderForBossDown> walletinListAdapter;
	/**
	 * 判断哪个时间选择控件选择了时间，用于回调
	 */
	private boolean iswhatChoiceOfDate;
	private int page = 0;// 需求页
	private int size = 12;// 默认页大小
	private boolean loadMoreOrRefresh = false;// 默认刷新
	private long loadCardSize = 0;// 已经加载会员数量
	private long totalCardSize = 0;// 总共会员数量

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.walletinoutrecordsactivty_layout_for_fragment_of_walletin, container, true);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addCallbackEventListener(EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETIN_CALLBACK);
	}

	@Override
	protected void OnInitUiAndData()
	{
		// TODO Auto-generated method stub
		super.OnInitUiAndData();
		onlinePayOrWithdrawOrderQueryUp = new OnlinePayOrWithdrawOrderQueryUp(page, size, null, SortType.up, null, null);
		vg_in_fragment_of_walletin_for_root = (ViewGroup) walletInOutRecordsActivty.findViewById(R.id.vg_in_fragment_of_walletin_for_root);// 根视图
		btn_in_fragment_of_walletin_for_date_start = (Button) vg_in_fragment_of_walletin_for_root.findViewById(R.id.btn_in_fragment_for_date_start);// 开始时间
		btn_in_fragment_of_walletin_for_date_end = (Button) vg_in_fragment_of_walletin_for_root.findViewById(R.id.btn_in_fragment_for_date_end);// 结束时间
		btn_in_fragment_of_walletin_for_date_start.setOnClickListener(this);
		btn_in_fragment_of_walletin_for_date_end.setOnClickListener(this);
		xlv_in_fragment_of_walletin_for_lists = (XListView) vg_in_fragment_of_walletin_for_root.findViewById(R.id.xlv_in_fragment_of_walletin_for_lists);// 收入
		xlv_in_fragment_of_walletin_for_lists.setXListViewListener(this);
		xlv_in_fragment_of_walletin_for_lists.setOnItemClickListener(this);
		walletinListAdapter = new WalletInAdapter<OnlinePayOrderForBossDown>(walletInOutRecordsActivty);
		walletinListAdapter.setOnListViewChildViewClickListener(this);
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
		xlv_in_fragment_of_walletin_for_lists.setAdapter(walletinListAdapter);
		xlv_in_fragment_of_walletin_for_lists.setPullLoadEnable(false);// 禁止加载
		xlv_in_fragment_of_walletin_for_lists.setPullRefreshEnable(true);// 开启刷新
		onRefresh();
	}

	@Override
	public void onRefresh()
	{
		// TODO Auto-generated method stub
		super.onRefresh();
		walletinListAdapter.removeAllItem(walletinListAdapter.getlistObject());
		page = 0;// 需求页
		size = 12;// 默认页大小
		loadMoreOrRefresh = false;// 默认刷新
		loadCardSize = 0;// 已经加载会员数量
		totalCardSize = 0;// 总共会员数量
		page = 0;
		onlinePayOrWithdrawOrderQueryUp.setPage(page);
		queryOnlinePayOrWithdrawOrderResults(onlinePayOrWithdrawOrderQueryUp, true);
	}

	@Override
	public void onLoadMore()
	{
		// TODO Auto-generated method stub
		super.onLoadMore();
		loadMoreOrRefresh = true;
		page++;
		onlinePayOrWithdrawOrderQueryUp.setPage(page);
		queryOnlinePayOrWithdrawOrderResults(onlinePayOrWithdrawOrderQueryUp, true);
	}

	/**
	 * 查询投诉消息
	 * 
	 * @param onlinePayOrWithdrawOrderQueryUp
	 * @param showDialog
	 */
	protected void queryOnlinePayOrWithdrawOrderResults(OnlinePayOrWithdrawOrderQueryUp onlinePayOrWithdrawOrderQueryUp, boolean showDialog)
	{

		if (showDialog)
		{
			DialogUtils.showLoading(walletInOutRecordsActivty, EventCode.HTTP_POST_QUERYONLINEPAYORDER);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERYONLINEPAYORDER, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERYONLINEPAYORDER, 0, URLUtils.URL_QUERYONLINEPAYORDER, onlinePayOrWithdrawOrderQueryUp);
	}

	@Override
	public void onEventRunEnd(BossAssistantBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
		if (eventCode == EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETIN_CALLBACK)
		{
			final BossAssistantBaseCallbackEvent callbackEvent = (BossAssistantBaseCallbackEvent) event;
			final Date a = (Date) callbackEvent.getReturnParam();
			if (iswhatChoiceOfDate)
			{
				onlinePayOrWithdrawOrderQueryUp.setBeginDate(a);
				btn_in_fragment_of_walletin_for_date_start.setText(DateUtil.dateToString(a, DateUtil.DATE_STYLE1));
				onRefresh();
			} else
			{
				if (onlinePayOrWithdrawOrderQueryUp.getBeginDate() != null)
				{
					if (DateUtil.isADataAfterBData(onlinePayOrWithdrawOrderQueryUp.getBeginDate(), a))
					{
						ToastManager.getInstance(walletInOutRecordsActivty).show("结束时间不能小于开始时间");
					} else
					{
						onlinePayOrWithdrawOrderQueryUp.setEndDate(a);
						btn_in_fragment_of_walletin_for_date_end.setText(DateUtil.dateToString(a, DateUtil.DATE_STYLE1));
						onRefresh();
					}
				} else
				{
					ToastManager.getInstance(walletInOutRecordsActivty).show("请先设置开始时间");
				}
			}
			return;
		} else if (eventCode == EventCode.HTTP_POST_QUERYONLINEPAYORDER)
		{
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERYONLINEPAYORDER);
			final QueryOnlinePayOrWithdrawOrderResultsEvent queryOnlinePayOrWithdrawOrderResultsEvent = (QueryOnlinePayOrWithdrawOrderResultsEvent) event;
			if (queryOnlinePayOrWithdrawOrderResultsEvent.isNetSuccess())
			{
				if (queryOnlinePayOrWithdrawOrderResultsEvent.isOk())
				{
					if (queryOnlinePayOrWithdrawOrderResultsEvent.getResult() != null && queryOnlinePayOrWithdrawOrderResultsEvent.getResult().getList() != null)
					{
						if (!loadMoreOrRefresh)
						{
							walletinListAdapter.replaceAll(queryOnlinePayOrWithdrawOrderResultsEvent.getResult().getList());
						} else
						{
							walletinListAdapter.addAllItem(queryOnlinePayOrWithdrawOrderResultsEvent.getResult().getList());
						}
						loadCardSize += queryOnlinePayOrWithdrawOrderResultsEvent.getResult().getList().size();
						walletinListAdapter.notifyDataSetChanged();
						totalCardSize = queryOnlinePayOrWithdrawOrderResultsEvent.getResult().getTotalCount();
						if (loadCardSize >= totalCardSize)
						{
							xlv_in_fragment_of_walletin_for_lists.setPullLoadEnable(false);// 禁止加载
							xlv_in_fragment_of_walletin_for_lists.setPullRefreshEnable(true);// 开启刷新
						} else
						{
							xlv_in_fragment_of_walletin_for_lists.setPullLoadEnable(true);// 开启刷新
							xlv_in_fragment_of_walletin_for_lists.setPullRefreshEnable(true);// 开启加载
						}
					}
				} else
				{
					if (queryOnlinePayOrWithdrawOrderResultsEvent.getErrorObject() == null)
					{
						walletInOutRecordsActivty.toastManager.show(queryOnlinePayOrWithdrawOrderResultsEvent.getStrHttpResult());
					} else
					{
						walletInOutRecordsActivty.toastManager.show(ErrorObject.formatError(queryOnlinePayOrWithdrawOrderResultsEvent.getErrorObject()));
					}
				}
				xlv_in_fragment_of_walletin_for_lists.stopRefresh();
				xlv_in_fragment_of_walletin_for_lists.stopLoadMore();
				xlv_in_fragment_of_walletin_for_lists.setRefreshTime(DateUtil.getStringDate());
			}
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// TODO Auto-generated method stub
		super.onItemClick(parent, view, position, id);
		Object object = parent.getItemAtPosition(position);
		if (object != null)
		{
			if (object instanceof EnterpriseNotificationDown)
			{
				EnterpriseNotificationDown c = (EnterpriseNotificationDown) object;
				ComplaintDetailsActivty.launch(walletInOutRecordsActivty, c);
			}
		}
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
		if (clickViewId == R.id.btn_in_fragment_for_date_start)
		{
			iswhatChoiceOfDate = true;
			DialogUtils
					.ShowNormalDateChoiceWithCallbackDialog(walletInOutRecordsActivty, EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETIN_CALLBACK, false);
		} else if (clickViewId == R.id.btn_in_fragment_for_date_end)
		{
			iswhatChoiceOfDate = false;
			DialogUtils
					.ShowNormalDateChoiceWithCallbackDialog(walletInOutRecordsActivty, EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETIN_CALLBACK, false);
		}
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		onlinePayOrWithdrawOrderQueryUp = null;
		isQueryFirstOK = false;
		vg_in_fragment_of_walletin_for_root = null;// 根视图
		btn_in_fragment_of_walletin_for_date_start = null;// 开始时间
		btn_in_fragment_of_walletin_for_date_end = null;// 结束时间
		iswhatChoiceOfDate = false;
		xlv_in_fragment_of_walletin_for_lists = null;
		walletinListAdapter.getlistObject().clear();
		walletinListAdapter = null;
		super.onDestroy();
	}

}

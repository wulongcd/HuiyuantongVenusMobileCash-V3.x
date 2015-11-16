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
import com.sintn.hera.assistant.adapter.fragment.WalletOutAdapter;
import com.sintn.hera.assistant.entity.conast.SortType;
import com.sintn.hera.assistant.entity.down.EnterpriseNotificationDown;
import com.sintn.hera.assistant.entity.down.ErrorObject;
import com.sintn.hera.assistant.entity.down.WithdrawOrderForBossDown;
import com.sintn.hera.assistant.entity.up.OnlinePayOrWithdrawOrderQueryUp;
import com.sintn.hera.assistant.event.BossAssistantBaseCallbackEvent;
import com.sintn.hera.assistant.event.BossAssistantBaseEvent;
import com.sintn.hera.assistant.event.httpevent.main.QueryWithdrawOrderForBossDownResultsEvent;
import com.sintn.hera.assistant.listener.OnListViewChildViewClickListener;
import com.sintn.hera.assistant.manager.AndroidEventManager;
import com.sintn.hera.assistant.utils.common.DateUtil;
import com.sintn.hera.assistant.utils.common.DialogUtils;
import com.sintn.hera.assistant.utils.common.ToastManager;
import com.sintn.hera.assistant.widget.view.xlistview.XListView;

/**
 * 
 * @Desc: 钱包提现记录
 * @com.sintn.hera.assistant.activity.main.fragment
 * @HuiyuantongVenusBossAssistant-V3.x
 * @Performance.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午4:28:35
 */

public class WalletOut extends BaseWalletInOutFragment implements OnListViewChildViewClickListener, OnClickListener
{

	private OnlinePayOrWithdrawOrderQueryUp onlinePayOrWithdrawOrderQueryUp = null;
	@SuppressWarnings("unused")
	private boolean isQueryFirstOK = false;
	private ViewGroup vg_in_fragment_of_walletout_for_root = null;// 根视图
	private Button btn_in_fragment_of_walletout_for_date_start = null;// 开始时间
	private Button btn_in_fragment_of_walletout_for_date_end = null;// 结束时间
	private XListView xlv_in_fragment_of_walletout_for_lists = null;
	private WalletOutAdapter<WithdrawOrderForBossDown> walletoutListAdapter;
	/**
	 * 判断哪个时间选择控件选择了时间，用于回调
	 */
	private boolean walletOutIswhatChoiceOfDate;
	private int page = 0;// 需求页
	private int size = 12;// 默认页大小
	private boolean loadMoreOrRefresh = false;// 默认刷新
	private long loadCardSize = 0;// 已经加载会员数量
	private long totalCardSize = 0;// 总共会员数量

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.walletinoutrecordsactivty_layout_for_fragment_of_walletout, container, true);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addCallbackEventListener(EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETOUT_CALLBACK);
	}

	@Override
	protected void OnInitUiAndData()
	{
		// TODO Auto-generated method stub
		super.OnInitUiAndData();
		onlinePayOrWithdrawOrderQueryUp = new OnlinePayOrWithdrawOrderQueryUp(page, size, null, SortType.up, null, null);
		vg_in_fragment_of_walletout_for_root = (ViewGroup) walletInOutRecordsActivty.findViewById(R.id.vg_in_fragment_of_walletout_for_root);// 根视图
		btn_in_fragment_of_walletout_for_date_start = (Button) vg_in_fragment_of_walletout_for_root.findViewById(R.id.btn_in_fragment_for_date_start);// 开始时间
		btn_in_fragment_of_walletout_for_date_end = (Button) vg_in_fragment_of_walletout_for_root.findViewById(R.id.btn_in_fragment_for_date_end);// 结束时间
		btn_in_fragment_of_walletout_for_date_start.setOnClickListener(this);
		btn_in_fragment_of_walletout_for_date_end.setOnClickListener(this);
		xlv_in_fragment_of_walletout_for_lists = (XListView) vg_in_fragment_of_walletout_for_root.findViewById(R.id.xlv_in_fragment_of_walletout_for_lists);// 收入
		xlv_in_fragment_of_walletout_for_lists.setXListViewListener(this);
		xlv_in_fragment_of_walletout_for_lists.setOnItemClickListener(this);
		walletoutListAdapter = new WalletOutAdapter<WithdrawOrderForBossDown>(walletInOutRecordsActivty);
		walletoutListAdapter.setOnListViewChildViewClickListener(this);
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
		xlv_in_fragment_of_walletout_for_lists.setAdapter(walletoutListAdapter);
		xlv_in_fragment_of_walletout_for_lists.setPullLoadEnable(false);// 禁止加载
		xlv_in_fragment_of_walletout_for_lists.setPullRefreshEnable(true);// 开启刷新
		onRefresh();
	}

	@Override
	public void onRefresh()
	{
		// TODO Auto-generated method stub
		super.onRefresh();
		walletoutListAdapter.removeAllItem(walletoutListAdapter.getlistObject());
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
			DialogUtils.showLoading(walletInOutRecordsActivty, EventCode.HTTP_POST_QUERYWITHDRAWORDER);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERYWITHDRAWORDER, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERYWITHDRAWORDER, 0, URLUtils.URL_QUERYWITHDRAWORDER, onlinePayOrWithdrawOrderQueryUp);
	}

	@Override
	public void onEventRunEnd(BossAssistantBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
		if (eventCode == EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETOUT_CALLBACK)
		{
			final BossAssistantBaseCallbackEvent callbackEvent = (BossAssistantBaseCallbackEvent) event;
			final Date a = (Date) callbackEvent.getReturnParam();
			if (walletOutIswhatChoiceOfDate)
			{
				onlinePayOrWithdrawOrderQueryUp.setBeginDate(a);
				btn_in_fragment_of_walletout_for_date_start.setText(DateUtil.dateToString(a, DateUtil.DATE_STYLE1));
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
						btn_in_fragment_of_walletout_for_date_end.setText(DateUtil.dateToString(a, DateUtil.DATE_STYLE1));
						onRefresh();
					}
				} else
				{
					ToastManager.getInstance(walletInOutRecordsActivty).show("请先设置开始时间");
				}
			}
			return;
		} else if (eventCode == EventCode.HTTP_POST_QUERYWITHDRAWORDER)
		{
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERYWITHDRAWORDER);
			final QueryWithdrawOrderForBossDownResultsEvent queryWithdrawOrderForBossDownResultsEvent = (QueryWithdrawOrderForBossDownResultsEvent) event;
			if (queryWithdrawOrderForBossDownResultsEvent.isNetSuccess())
			{
				if (queryWithdrawOrderForBossDownResultsEvent.isOk())
				{
					if (queryWithdrawOrderForBossDownResultsEvent.getResult() != null && queryWithdrawOrderForBossDownResultsEvent.getResult().getList() != null)
					{
						if (!loadMoreOrRefresh)
						{
							walletoutListAdapter.replaceAll(queryWithdrawOrderForBossDownResultsEvent.getResult().getList());
						} else
						{
							walletoutListAdapter.addAllItem(queryWithdrawOrderForBossDownResultsEvent.getResult().getList());
						}
						loadCardSize += queryWithdrawOrderForBossDownResultsEvent.getResult().getList().size();
						walletoutListAdapter.notifyDataSetChanged();
						totalCardSize = queryWithdrawOrderForBossDownResultsEvent.getResult().getTotalCount();
						if (loadCardSize >= totalCardSize)
						{
							xlv_in_fragment_of_walletout_for_lists.setPullLoadEnable(false);// 禁止加载
							xlv_in_fragment_of_walletout_for_lists.setPullRefreshEnable(true);// 开启刷新
						} else
						{
							xlv_in_fragment_of_walletout_for_lists.setPullLoadEnable(true);// 开启刷新
							xlv_in_fragment_of_walletout_for_lists.setPullRefreshEnable(true);// 开启加载
						}
					}
				} else
				{
					if (queryWithdrawOrderForBossDownResultsEvent.getErrorObject() == null)
					{
						walletInOutRecordsActivty.toastManager.show(queryWithdrawOrderForBossDownResultsEvent.getStrHttpResult());
					} else
					{
						walletInOutRecordsActivty.toastManager.show(ErrorObject.formatError(queryWithdrawOrderForBossDownResultsEvent.getErrorObject()));
					}
				}
				xlv_in_fragment_of_walletout_for_lists.stopRefresh();
				xlv_in_fragment_of_walletout_for_lists.stopLoadMore();
				xlv_in_fragment_of_walletout_for_lists.setRefreshTime(DateUtil.getStringDate());
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
			walletOutIswhatChoiceOfDate = true;
			DialogUtils.ShowNormalDateChoiceWithCallbackDialog(walletInOutRecordsActivty, EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETOUT_CALLBACK,
					false);
		} else if (clickViewId == R.id.btn_in_fragment_for_date_end)
		{
			walletOutIswhatChoiceOfDate = false;
			DialogUtils.ShowNormalDateChoiceWithCallbackDialog(walletInOutRecordsActivty, EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETOUT_CALLBACK,
					false);
		}
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		onlinePayOrWithdrawOrderQueryUp = null;
		isQueryFirstOK = false;
		vg_in_fragment_of_walletout_for_root = null;// 根视图
		btn_in_fragment_of_walletout_for_date_start = null;// 开始时间
		btn_in_fragment_of_walletout_for_date_end = null;// 结束时间
		walletOutIswhatChoiceOfDate = false;
		xlv_in_fragment_of_walletout_for_lists = null;
		walletoutListAdapter.getlistObject().clear();
		walletoutListAdapter = null;
		super.onDestroy();
	}

}

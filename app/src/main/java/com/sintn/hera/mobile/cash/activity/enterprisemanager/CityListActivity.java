package com.sintn.hera.mobile.cash.activity.enterprisemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.activity.login.SecondCategoryActivity;
import com.sintn.hera.mobile.cash.adapter.RegionListAdapter;
import com.sintn.hera.mobile.cash.entity.down.CategoryForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.down.RegionForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.up.RegionForCashierAppQueryUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryFirstCategoryEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QuerySubRegionEvent;
import com.sintn.hera.mobile.cash.listener.OnRecyclerViewItemClickListener;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.widget.pullrecycle.PtrRecyclerView;
import com.sintn.hera.mobile.cash.widget.pullrecycle.PullToRefreshBase;

import java.util.ArrayList;

/**
 * 
 * @Desc: 一级行业选择界面
 * @com.sintn.hera.mobile.cash.activity.main
 * @HuiyuantongVenusMobileCash-V3.x
 * @ChoiceServerActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-8下午2:11:12
 */
public class CityListActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2, OnRecyclerViewItemClickListener
{
	//查询条件-需求页
	private int page = 0;
	//查询条件-默认页大小
	private int size = 12;
	// 默认刷新,用于判断当前操作是刷新还是加载更多
	private boolean loadMoreOrRefresh = false;
	//已经加载数量
	private long loadSize = 0;
	private RelativeLayout rl_in_cityListActivity_of_header = null;
	private PtrRecyclerView prv_in_cityListActivity_for_lists = null;
    private LinearLayoutManager manager;
	private RegionListAdapter regionListAdapter = null;
	private Button btn_in_cityListActivity_for_back = null;
	private TextView tv_in_cityListActivity_for_title = null;
	private TextView tv_in_cityListActivity_for_header = null;
	private RegionForCashierAppQueryUp regionForCashierAppQueryUp = null;
	private String code;

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
		rl_in_cityListActivity_of_header = (RelativeLayout) findViewById(R.id.rl_in_cityListActivity_of_header);
		tv_in_cityListActivity_for_header = (TextView) rl_in_cityListActivity_of_header.findViewById(R.id.tv_in_categoryItem_of_desc);
		prv_in_cityListActivity_for_lists = (PtrRecyclerView) findViewById(R.id.prv_in_cityListActivity_for_lists);
		btn_in_cityListActivity_for_back = (Button) findViewById(R.id.btn_normal_title_for_back);
		tv_in_cityListActivity_for_title = (TextView) findViewById(R.id.tv_normal_title_for_show_title);
		regionForCashierAppQueryUp = new RegionForCashierAppQueryUp();
		regionListAdapter = new RegionListAdapter(this);
		code = getIntent().hasExtra("code") ? getIntent().getStringExtra("code") : "";
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
		regionListAdapter.setRegionMode(RegionListAdapter.RegionMode.REGION_OF_CITY);
		regionListAdapter.setOnRecyclerViewItemClickListener(this);
		prv_in_cityListActivity_for_lists.setAdapter(regionListAdapter);
		prv_in_cityListActivity_for_lists.setMode(PullToRefreshBase.Mode.BOTH);
		prv_in_cityListActivity_for_lists.setOnRefreshListener(this);
        prv_in_cityListActivity_for_lists.setLayoutManager(manager);
		rl_in_cityListActivity_of_header.setBackgroundColor(getResources().getColor(R.color.base_bg));
		rl_in_cityListActivity_of_header.findViewById(R.id.iv_in_categoryItem_of_isSelected).setVisibility(View.GONE);
		tv_in_cityListActivity_for_header.setText(R.string.choose_city);
		tv_in_cityListActivity_for_header.setTextSize(DensityManagerUtils.px2sp(this, getResources().getDimension(R.dimen.middle_textSize)));
		tv_in_cityListActivity_for_title.setText(R.string.choose_city);
		btn_in_cityListActivity_for_back.setOnClickListener(this);
		regionForCashierAppQueryUp.setCode(code);
		initRegionForCashierAppQueryUp();
		querySubRegion(true);
	}

	/**
	 * 获取下级地区
	 * @param isShow 是否显示加载动画
	 */
	public void querySubRegion(boolean isShow) {
		if(isShow) {
			DialogUtils.showLoading(this, EventCode.HTTP_POST_QUERY_SUB_REGION_LIST);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERY_SUB_REGION_LIST, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERY_SUB_REGION_LIST, 0, URLUtils.URL_POST_QUERY_SUB_REGION, regionForCashierAppQueryUp);
	}
	/**
	 * 初始化下级地区查询上行实体
	 */
	private void initRegionForCashierAppQueryUp() {
		if(loadMoreOrRefresh) {
			page++;
		} else {
			page = 0;
			loadSize = 0;
		}
		regionForCashierAppQueryUp.setPage(page);
		regionForCashierAppQueryUp.setSize(size);
	}

	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
		if (EventCode.HTTP_POST_QUERY_SUB_REGION_LIST == eventCode) {
			DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERY_SUB_REGION_LIST);
			final QuerySubRegionEvent querySubRegionEvent = (QuerySubRegionEvent) event;
			if (querySubRegionEvent.isNetSuccess()) {
				if (querySubRegionEvent.isOk()) {
					if (querySubRegionEvent.getResult() != null) {
						CommonPagerDown commonPagerDown = querySubRegionEvent.getResult();
						if (loadMoreOrRefresh) {
							regionListAdapter.addAllItem(commonPagerDown.getList());
						} else {
							regionListAdapter.replaceAll(commonPagerDown.getList());
						}
						loadSize += commonPagerDown.getList().size();
						regionListAdapter.notifyDataSetChanged();
						if(loadSize < commonPagerDown.getTotalCount()) {
							prv_in_cityListActivity_for_lists.setMode(PullToRefreshBase.Mode.BOTH);
						} else {
							prv_in_cityListActivity_for_lists.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
						}
					}
				} else {
					if (querySubRegionEvent.getErrorObject() == null) {
						toastManager.show(querySubRegionEvent.getStrHttpResult());
					} else {
						toastManager.show(ErrorObject.formatError(querySubRegionEvent.getErrorObject()));
					}
				}
				prv_in_cityListActivity_for_lists.onRefreshComplete();
			}
			prv_in_cityListActivity_for_lists.onRefreshComplete();
		}
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		super.onClick(v);
		switch (clickedViewId) {
			case R.id.btn_normal_title_for_back:
				onBackPressed();
				break;
			default:
				break;
		}
	}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK) {
            BaseApplication.getLocalManager();
            regionListAdapter.getSelectedRegions();
            data.putParcelableArrayListExtra(RegionListAdapter.RegionList.CITY, regionListAdapter.getSelectedRegions());
            this.setResult(RESULT_OK, data);
            this.finish();
        }
    }

    @Override
	protected void onInitAttribute(ActivityBaseAttribute ba)
	{
		super.onInitAttribute(ba);
		ba.setHasNavigationBar(false);
	}

	public static void launch(Activity activity, String code)
	{
		if (!CommonUtils.isActivityAreRunningBefore(activity, CityListActivity.class))
		{
			Intent intent = new Intent(activity, CityListActivity.class);
			intent.putExtra("code", code);
			activity.startActivityForResult(intent, 0);
		}
	}

	@Override
	public void onBackPressed()
	{
		// TODO Auto-generated method stub
		super.onBackPressed();
		this.finish();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
	}

	@Override
	public void onPullDownToRefresh(PullToRefreshBase refreshView) {
		loadMoreOrRefresh = false;
		initRegionForCashierAppQueryUp();
		querySubRegion(false);
	}

	@Override
	public void onPullUpToRefresh(PullToRefreshBase refreshView) {
		loadMoreOrRefresh = true;
		initRegionForCashierAppQueryUp();
		querySubRegion(false);
	}

	@Override
	public void OnRecyclerViewItemClicked(int position) {
		RegionForCashierAppDown regionForCashierAppDown = (RegionForCashierAppDown) regionListAdapter.getItem(position);
        ArrayList<RegionForCashierAppDown> list = regionListAdapter.getSelectedRegions();
        list.clear();
        list.add(regionForCashierAppDown);
        regionListAdapter.notifyDataSetChanged();
		AreaListActivity.launch(this, regionForCashierAppDown.getCode());
	}
}

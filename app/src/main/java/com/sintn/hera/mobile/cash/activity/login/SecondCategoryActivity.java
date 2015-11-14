package com.sintn.hera.mobile.cash.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.adapter.CategoryListAdapter;
import com.sintn.hera.mobile.cash.entity.down.CategoryForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.up.Category2ForCashierAppQueryUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QuerySecondCategoryEvent;
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
 * @Desc: 二级行业选择界面
 * @com.sintn.hera.mobile.cash.activity.main
 * @HuiyuantongVenusMobileCash-V3.x
 * @ChoiceServerActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-8下午2:11:12
 */
public class SecondCategoryActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2, OnRecyclerViewItemClickListener
{
	//查询条件-需求页
	private int page = 0;
	//查询条件-默认页大小
	private int size = 12;
	// 默认刷新,用于判断当前操作是刷新还是加载更多
	private boolean loadMoreOrRefresh = false;
	//已经加载数量
	private long loadSize = 0;
	private long firstCategoryId = 0;
	private PtrRecyclerView prv_in_secondCategoryActivity_for_lists = null;
	private CategoryListAdapter categoryListAdapter = null;
	private Button btn_in_secondCategoryActivity_for_back = null;
	private Button btn_in_secondCategoryActivity_for_submit = null;
	private TextView tv_in_secondCategoryActivity_for_title = null;
	private TextView tv_in_secondCategoryActivity_for_header = null;
	private RelativeLayout rl_in_secondCategoryActivity_of_header = null;
	private LinearLayoutManager manager = null;
	private Category2ForCashierAppQueryUp category2ForCashierAppQueryUp = null;

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
		prv_in_secondCategoryActivity_for_lists = (PtrRecyclerView) findViewById(R.id.prv_in_secondCategoryActivity_for_lists);
		rl_in_secondCategoryActivity_of_header = (RelativeLayout) findViewById(R.id.rl_in_secondCategoryActivity_of_header);
		tv_in_secondCategoryActivity_for_header = (TextView) rl_in_secondCategoryActivity_of_header.findViewById(R.id.tv_in_categoryItem_of_desc);
		btn_in_secondCategoryActivity_for_back = (Button) findViewById(R.id.btn_normal_title_for_back);
        btn_in_secondCategoryActivity_for_submit = (Button) findViewById(R.id.btn_normal_title_for_right);
		tv_in_secondCategoryActivity_for_title = (TextView) findViewById(R.id.tv_normal_title_for_show_title);
		category2ForCashierAppQueryUp = new Category2ForCashierAppQueryUp();
        categoryListAdapter = new CategoryListAdapter(this);
		firstCategoryId = getIntent().getLongExtra("firstCategoryId", 0);
		category2ForCashierAppQueryUp.setId(firstCategoryId);
		initCategory2ForCashierAppQueryUp();
	}

	@Override
	protected void OnBindDataWithUi()
	{
		// TODO Auto-generated method stub
		super.OnBindDataWithUi();
        manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryListAdapter.setOnRecyclerViewItemClickListener(this);
		categoryListAdapter.setCategoryMode(CategoryListAdapter.CategoryMode.CATEGORY_SECOND);
        prv_in_secondCategoryActivity_for_lists.setMode(PullToRefreshBase.Mode.BOTH);
        prv_in_secondCategoryActivity_for_lists.setAdapter(categoryListAdapter);
        prv_in_secondCategoryActivity_for_lists.setOnRefreshListener(this);
        prv_in_secondCategoryActivity_for_lists.setLayoutManager(manager);
		rl_in_secondCategoryActivity_of_header.setBackgroundColor(getResources().getColor(R.color.base_bg));
		rl_in_secondCategoryActivity_of_header.findViewById(R.id.iv_in_categoryItem_of_isSelected).setVisibility(View.GONE);
		tv_in_secondCategoryActivity_for_header.setText(R.string.choose_second_category);
		tv_in_secondCategoryActivity_for_header.setTextSize(DensityManagerUtils.px2sp(this, getResources().getDimension(R.dimen.middle_textSize)));
		tv_in_secondCategoryActivity_for_title.setText(R.string.choose_category);
		btn_in_secondCategoryActivity_for_back.setOnClickListener(this);
        btn_in_secondCategoryActivity_for_submit.setOnClickListener(this);
        btn_in_secondCategoryActivity_for_submit.setText(R.string.string_of_submit);
		getSecondIndustry(true);
	}

	/**
	 * 获取二级行业
	 * @param isShow 是否显示加载动画
	 */
	public void getSecondIndustry(boolean isShow) {
		if(isShow) {
			DialogUtils.showLoading(this, EventCode.HTTP_POST_QUERY_SECOND_CATEGORY_LIST);
		}
		AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERY_SECOND_CATEGORY_LIST, this, true);
		AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERY_SECOND_CATEGORY_LIST, 0, URLUtils.URL_POST_QUERY_SECOND_CATEGORY_LIST, category2ForCashierAppQueryUp);
	}

	/**
	 * 初始化二级行业查询上行实体
	 */
	private void initCategory2ForCashierAppQueryUp() {
		if(loadMoreOrRefresh) {
            page++;
        } else {
            page = 0;
            loadSize = 0;
        }
        category2ForCashierAppQueryUp.setSize(size);
        category2ForCashierAppQueryUp.setPage(page);
	}

	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
		// TODO Auto-generated method stub
		super.onEventRunEnd(event);
		if (EventCode.HTTP_POST_QUERY_SECOND_CATEGORY_LIST == eventCode) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERY_SECOND_CATEGORY_LIST);
            final QuerySecondCategoryEvent querySecondCategoryEvent = (QuerySecondCategoryEvent) event;
            if (querySecondCategoryEvent.isNetSuccess()) {
                if (querySecondCategoryEvent.isOk()) {
                    if (querySecondCategoryEvent.getResult() != null) {
                        CommonPagerDown commonPagerDown = querySecondCategoryEvent.getResult();
                        if (loadMoreOrRefresh) {
                            categoryListAdapter.addAllItem(commonPagerDown.getList());
                        } else {
                            categoryListAdapter.replaceAll(commonPagerDown.getList());
                        }
                        loadSize += commonPagerDown.getList().size();
                        categoryListAdapter.notifyDataSetChanged();
                        if(loadSize < commonPagerDown.getTotalCount()) {
                            prv_in_secondCategoryActivity_for_lists.setMode(PullToRefreshBase.Mode.BOTH);
                        } else {
                            prv_in_secondCategoryActivity_for_lists.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                        }
                    }
                } else {
                    if (querySecondCategoryEvent.getErrorObject() == null) {
                        toastManager.show(querySecondCategoryEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(querySecondCategoryEvent.getErrorObject()));
                    }
                }
                prv_in_secondCategoryActivity_for_lists.onRefreshComplete();
            }
            prv_in_secondCategoryActivity_for_lists.onRefreshComplete();
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
			case R.id.btn_normal_title_for_right:
                Intent intent = new Intent();
                this.setResult(RESULT_OK, intent);
                intent.putParcelableArrayListExtra("secondCategories", categoryListAdapter.getSelectedCategories());
                this.finish();
				break;
			default:
				break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		// TODO Auto-generated method stub
		super.onItemClick(parent, view, position, id);
		CategoryForCashierAppDown object = (CategoryForCashierAppDown) parent.getItemAtPosition(position);
		if (object != null)
		{
		}
	}

	@Override
	protected void onInitAttribute(ActivityBaseAttribute ba)
	{
		super.onInitAttribute(ba);
		ba.setHasNavigationBar(false);
	}

	public static void launch(Activity activity)
	{
		if (!CommonUtils.isActivityAreRunningBefore(activity, SecondCategoryActivity.class))
		{
			Intent intent = new Intent(activity, SecondCategoryActivity.class);
			activity.startActivityForResult(intent, 0);
		}
	}

	public static void launch(Activity activity, long firstCategoryId)
	{
		if (!CommonUtils.isActivityAreRunningBefore(activity, SecondCategoryActivity.class))
		{
			Intent intent = new Intent(activity, SecondCategoryActivity.class);
			intent.putExtra("firstCategoryId", firstCategoryId);
			activity.startActivityForResult(intent, 0);
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

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        loadMoreOrRefresh = false;
        initCategory2ForCashierAppQueryUp();
        getSecondIndustry(false);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        loadMoreOrRefresh = true;
        initCategory2ForCashierAppQueryUp();
        getSecondIndustry(false);
    }

    @Override
    public void OnRecyclerViewItemClicked(int position) {
        CategoryForCashierAppDown categoryForCashierAppDown = (CategoryForCashierAppDown) categoryListAdapter.getItem(position);
        ArrayList<CategoryForCashierAppDown> lists = categoryListAdapter.getSelectedCategories();
        if(lists.contains(categoryForCashierAppDown)) {
            lists.remove(categoryForCashierAppDown);
        } else {
            lists.add(categoryForCashierAppDown);
        }
        categoryListAdapter.notifyDataSetChanged();
    }
}

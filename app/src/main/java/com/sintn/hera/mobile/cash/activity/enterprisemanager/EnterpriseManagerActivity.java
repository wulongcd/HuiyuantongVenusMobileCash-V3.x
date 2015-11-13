package com.sintn.hera.mobile.cash.activity.enterprisemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.activity.login.FirstCategoryActivity;
import com.sintn.hera.mobile.cash.adapter.ShopListAdapter;
import com.sintn.hera.mobile.cash.entity.down.CategoryForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.EnterpriseForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.down.ShopForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.up.CommonPagerUp;
import com.sintn.hera.mobile.cash.entity.up.EnterpriseForCashierAppUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryEnterpriseInfoEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryShopListEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.UpdateEnterpriseInfoEvent;
import com.sintn.hera.mobile.cash.listener.OnRecyclerViewItemClickListener;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.widget.pullrecycle.PtrRecyclerView;
import com.sintn.hera.mobile.cash.widget.pullrecycle.PullToRefreshBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 企业管理界面
 * @com.sintn.hera.mobile.cash.activity.login
 * @HuiyuantongVenusWokerAssistant-V3.x
 * @LoginActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-8-4下午4:51:01
 */

public class EnterpriseManagerActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2, OnRecyclerViewItemClickListener {
    //查询条件-需求页
    private int page = 0;
    //查询条件-默认页大小
    private int size = 12;
    // 默认刷新,用于判断当前操作是刷新还是加载更多
    private boolean loadMoreOrRefresh = false;
    //已经加载数量
    private long loadSize = 0;
    private TextView tv_in_enterpriseManagerActivity_of_title = null;
    private TextView tv_in_enterpriseManagerActivity_of_enterpriseInfo = null;
    private TextView tv_in_enterpriseManagerActivity_of_shopList = null;
    private TextView tv_in_enterpriseManagerActivity_of_enterpriseName = null;
    private TextView tv_in_enterpriseManagerActivity_of_industry = null;
    private TextView tv_in_enterpriseManagerActivity_of_detailedAddress = null;
    private EditText et_in_enterpriseManagerActivity_of_enterpriseName = null;
    private Button btn_in_enterpriseManagerActivity_of_industry = null;
    private EditText et_in_enterpriseManagerActivity_of_detailedAddress = null;
    private EditText et_in_enterpriseManagerActivity_of_enterprisePhone = null;
    private Button btn_in_enterpriseManagerActivity_of_back = null;
    private Button btn_in_enterpriseManagerActivity_of_submit = null;
    private Button btn_in_enterpriseManagerActivity_of_unbindPhone = null;
    private FloatingActionButton fBtn_in_enterpriseManagerActivity_of_add = null;
    private ImageView iv_in_enterpriseManagerActivity_of_enterpriseInfo = null;
    private ImageView iv_in_enterpriseManagerActivity_of_shopList = null;
    private PtrRecyclerView prv_in_enterpriseManagerActivity_for_list = null;
    private RelativeLayout rl_in_enterpriseManagerActivity_of_enterpriseInfo = null;
    private RelativeLayout rl_in_enterpriseManagerActivity_of_shopList = null;
    private LinearLayout ll_in_enterpriseManagerActivity_of_enterpriseName = null;
    private LinearLayout ll_in_enterpriseManagerActivity_of_industry = null;
    private LinearLayout ll_in_enterpriseManagerActivity_of_detailedAddress = null;
    private CommonPagerUp commonPagerUp = null;
    private ShopListAdapter<ShopForCashierAppDown> shopListAdapter = null;
    private EnterpriseForCashierAppUp enterpriseForCashierAppUp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();
        tv_in_enterpriseManagerActivity_of_title = (TextView) findViewById(R.id.tv_normal_title_for_show_title);
        btn_in_enterpriseManagerActivity_of_back = (Button) findViewById(R.id.btn_normal_title_for_back);
        btn_in_enterpriseManagerActivity_of_submit = (Button) findViewById(R.id.btn_normal_title_for_right);

        btn_in_enterpriseManagerActivity_of_unbindPhone = (Button) findViewById(R.id.btn_in_enterpriseManagerActivity_of_unbindPhone);
        et_in_enterpriseManagerActivity_of_enterprisePhone = (EditText) findViewById(R.id.et_in_enterpriseManagerActivity_of_enterprisePhone);
        prv_in_enterpriseManagerActivity_for_list = (PtrRecyclerView) findViewById(R.id.prv_in_enterpriseManagerActivity_for_list);
        fBtn_in_enterpriseManagerActivity_of_add = (FloatingActionButton) findViewById(R.id.fBtn_in_enterpriseManagerActivity_of_add);

        rl_in_enterpriseManagerActivity_of_enterpriseInfo = (RelativeLayout) findViewById(R.id.rl_in_enterpriseManagerActivity_of_enterpriseInfo);
        tv_in_enterpriseManagerActivity_of_enterpriseInfo = (TextView) rl_in_enterpriseManagerActivity_of_enterpriseInfo.findViewById(R.id.tv_in_managerActivity_item_of_name);
        iv_in_enterpriseManagerActivity_of_enterpriseInfo = (ImageView) rl_in_enterpriseManagerActivity_of_enterpriseInfo.findViewById(R.id.iv_in_managerActivity_item_of_logo);

        rl_in_enterpriseManagerActivity_of_shopList = (RelativeLayout) findViewById(R.id.rl_in_enterpriseManagerActivity_of_shopList);
        tv_in_enterpriseManagerActivity_of_shopList = (TextView) rl_in_enterpriseManagerActivity_of_shopList.findViewById(R.id.tv_in_managerActivity_item_of_name);
        iv_in_enterpriseManagerActivity_of_shopList = (ImageView) rl_in_enterpriseManagerActivity_of_shopList.findViewById(R.id.iv_in_managerActivity_item_of_logo);

        ll_in_enterpriseManagerActivity_of_enterpriseName = (LinearLayout) findViewById(R.id.ll_in_enterpriseManagerActivity_of_enterpriseName);
        tv_in_enterpriseManagerActivity_of_enterpriseName = (TextView) ll_in_enterpriseManagerActivity_of_enterpriseName.findViewById(R.id.tv_in_infoActivity_item);
        et_in_enterpriseManagerActivity_of_enterpriseName = (EditText) ll_in_enterpriseManagerActivity_of_enterpriseName.findViewById(R.id.et_in_infoActivity_item);

        ll_in_enterpriseManagerActivity_of_industry = (LinearLayout) findViewById(R.id.ll_in_enterpriseManagerActivity_of_industry);
        tv_in_enterpriseManagerActivity_of_industry = (TextView) ll_in_enterpriseManagerActivity_of_industry.findViewById(R.id.tv_in_editItem_of_industry);
        btn_in_enterpriseManagerActivity_of_industry = (Button) ll_in_enterpriseManagerActivity_of_industry.findViewById(R.id.btn_in_editItem_of_industry);

        ll_in_enterpriseManagerActivity_of_detailedAddress = (LinearLayout) findViewById(R.id.ll_in_enterpriseManagerActivity_of_detailedAddress);
        tv_in_enterpriseManagerActivity_of_detailedAddress = (TextView) ll_in_enterpriseManagerActivity_of_detailedAddress.findViewById(R.id.tv_in_infoActivity_item);
        et_in_enterpriseManagerActivity_of_detailedAddress = (EditText) ll_in_enterpriseManagerActivity_of_detailedAddress.findViewById(R.id.et_in_infoActivity_item);

        shopListAdapter = new ShopListAdapter<ShopForCashierAppDown>(this);
        commonPagerUp = new CommonPagerUp();
        enterpriseForCashierAppUp = new EnterpriseForCashierAppUp();
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
        tv_in_enterpriseManagerActivity_of_title.setText(R.string.string_of_enterpriseManager);
        btn_in_enterpriseManagerActivity_of_submit.setText(R.string.string_of_submit);

        btn_in_enterpriseManagerActivity_of_unbindPhone.setVisibility(View.GONE);
        tv_in_enterpriseManagerActivity_of_enterpriseInfo.setText(R.string.string_of_enterpriseInfo);
        iv_in_enterpriseManagerActivity_of_enterpriseInfo.setBackgroundResource(R.drawable.enterprise_info);
        tv_in_enterpriseManagerActivity_of_shopList.setText(R.string.string_of_shopList);
        iv_in_enterpriseManagerActivity_of_shopList.setBackgroundResource(R.drawable.shop_list);

        shopListAdapter.setOnRecyclerViewItemClickListener(this);
        prv_in_enterpriseManagerActivity_for_list.setAdapter(shopListAdapter);
        prv_in_enterpriseManagerActivity_for_list.setMode(PullToRefreshBase.Mode.BOTH);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        prv_in_enterpriseManagerActivity_for_list.setLayoutManager(manager);
        prv_in_enterpriseManagerActivity_for_list.setOnRefreshListener(this);
        fBtn_in_enterpriseManagerActivity_of_add.setOnClickListener(this);
        btn_in_enterpriseManagerActivity_of_back.setOnClickListener(this);
        btn_in_enterpriseManagerActivity_of_submit.setOnClickListener(this);
        btn_in_enterpriseManagerActivity_of_industry.setOnClickListener(this);

        ll_in_enterpriseManagerActivity_of_enterpriseName.setBackgroundColor(getResources().getColor(R.color.white));
        ll_in_enterpriseManagerActivity_of_detailedAddress.setBackgroundColor(getResources().getColor(R.color.white));
        ll_in_enterpriseManagerActivity_of_industry.setBackgroundColor(getResources().getColor(R.color.white));
        tv_in_enterpriseManagerActivity_of_enterpriseName.setText(R.string.string_of_enterpriseName);
        tv_in_enterpriseManagerActivity_of_detailedAddress.setText(R.string.string_of_detailAddress);
        tv_in_enterpriseManagerActivity_of_industry.setText(R.string.string_of_industry);
        et_in_enterpriseManagerActivity_of_enterpriseName.setHint("");
        et_in_enterpriseManagerActivity_of_detailedAddress.setHint("");
        btn_in_enterpriseManagerActivity_of_industry.setHint("");
        et_in_enterpriseManagerActivity_of_enterprisePhone.setEnabled(false);
        queryEnterpriseInfo(true);
        initCommonPagerUp();
        queryShopList(true);
    }

    /**
     * 初始化店铺列表查询实体
     */
    private void initCommonPagerUp() {
        if(loadMoreOrRefresh) {
            page++;
        } else {
            page = 0;
            loadSize = 0;
        }
        commonPagerUp.setPage(page);
        commonPagerUp.setSize(size);
    }

    /**
     * 初始化企业信息更新实体
     */
    private boolean initEnterpriseForCashierAppUp() {
        if(et_in_enterpriseManagerActivity_of_enterpriseName.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.enterpriseName_is_null);
            return false;
        }
        if(btn_in_enterpriseManagerActivity_of_industry.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.industry_is_null);
            return false;
        }
        if(et_in_enterpriseManagerActivity_of_detailedAddress.getText().toString().trim().length() <=0) {
            toastManager.show(R.string.detailAddress_is_null);
            return false;
        }
        enterpriseForCashierAppUp.setAddress(et_in_enterpriseManagerActivity_of_detailedAddress.getText().toString().trim());
        enterpriseForCashierAppUp.setName(et_in_enterpriseManagerActivity_of_enterpriseName.getText().toString().trim());
        return true;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
        switch (clickedViewId) {
            case R.id.btn_normal_title_for_back:
                onBackPressed();
                break;
            case R.id.btn_in_editItem_of_industry:
                FirstCategoryActivity.launch(this);
                break;
            case R.id.btn_normal_title_for_right:
                if(initEnterpriseForCashierAppUp()) {
                    updateEnterpriseInfo(true);
                }
                break;
            case R.id.fBtn_in_enterpriseManagerActivity_of_add:
                ShopManagerActivity.lunch(this);
                break;
            default:
                break;
        }
    }

    /**
     * 查询企业基本信息
     * @param isShow 是否显示加载动画
     */
    private void queryEnterpriseInfo(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_GET_QUERY_ENTERPRISE_INFO);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_QUERY_ENTERPRISE_INFO, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_QUERY_ENTERPRISE_INFO, 0, URLUtils.URL_GET_QUERY_ENTERPRISE_INFO);
    }

    /**
     * 更新企业基本信息
     * @param isShow 是否显示加载动画
     */
    private void updateEnterpriseInfo(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_UPDATE_ENTERPRISE_INFO);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_UPDATE_ENTERPRISE_INFO, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_UPDATE_ENTERPRISE_INFO, 0, URLUtils.URL_POST_UPDATE_ENTERPRISE_INFO);
    }

    /**
     * 查询店铺列表
     * @param isShow 是否显示加载动画
     */
    private void queryShopList(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_QUERY_SHOP_LIST);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERY_SHOP_LIST, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERY_SHOP_LIST, 0, URLUtils.URL_POST_QUERY_SHOP_LIST, commonPagerUp);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        super.onEventRunEnd(event);
        if(eventCode == EventCode.HTTP_GET_QUERY_ENTERPRISE_INFO) {
            DialogUtils.dissMissLoading(EventCode.HTTP_GET_QUERY_ENTERPRISE_INFO);
            QueryEnterpriseInfoEvent queryEnterpriseInfoEvent = (QueryEnterpriseInfoEvent) event;
            if(queryEnterpriseInfoEvent.isNetSuccess()) {
                if(queryEnterpriseInfoEvent.isOk()) {
                    if(queryEnterpriseInfoEvent.getResult() != null) {
                        EnterpriseForCashierAppDown enterpriseForCashierAppDown = queryEnterpriseInfoEvent.getResult();
                        et_in_enterpriseManagerActivity_of_enterpriseName.setText(enterpriseForCashierAppDown.getName());
                        et_in_enterpriseManagerActivity_of_detailedAddress.setText(enterpriseForCashierAppDown.getAddress());
                        et_in_enterpriseManagerActivity_of_enterprisePhone.setText(enterpriseForCashierAppDown.getPhone());
                        List<CategoryForCashierAppDown> list = enterpriseForCashierAppDown.getCategory2s();
                        String industry = enterpriseForCashierAppDown.getCategory1().getName();
                        for(int i=0;i<list.size();i++) {
                            if(list.get(i) != null) {
                                if(i == 0) {
                                    industry += "：" + list.get(i).getName();
                                } else {
                                    industry += "/" + list.get(i).getName();
                                }
                            }
                        }
                        btn_in_enterpriseManagerActivity_of_industry.setText(industry);
                    }
                } else {
                    if(queryEnterpriseInfoEvent.getErrorObject() == null) {
                        toastManager.show(queryEnterpriseInfoEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(queryEnterpriseInfoEvent.getErrorObject()));
                    }
                }
            }
        } else if(eventCode == EventCode.HTTP_POST_QUERY_SHOP_LIST) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERY_SHOP_LIST);
            QueryShopListEvent queryShopListEvent = (QueryShopListEvent) event;
            if(queryShopListEvent.isNetSuccess()) {
                if(queryShopListEvent.isOk()) {
                    if(queryShopListEvent.getResult() != null) {
                        CommonPagerDown<ShopForCashierAppDown> commonPagerDown = queryShopListEvent.getResult();
                        List<ShopForCashierAppDown> shopForCashierAppDowns = commonPagerDown.getList();
                        if(loadMoreOrRefresh) {
                            shopListAdapter.addAllItem(shopForCashierAppDowns);
                        } else {
                            shopListAdapter.replaceAll(shopForCashierAppDowns);
                        }
                        loadSize += shopForCashierAppDowns.size();
                        if(loadSize < commonPagerDown.getTotalCount()) {
                            prv_in_enterpriseManagerActivity_for_list.setMode(PullToRefreshBase.Mode.BOTH);
                        } else {
                            prv_in_enterpriseManagerActivity_for_list.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                        }
                    }
                } else {
                    if(queryShopListEvent.getErrorObject() == null) {
                        toastManager.show(queryShopListEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(queryShopListEvent.getErrorObject()));
                    }
                }
            }
            prv_in_enterpriseManagerActivity_for_list.onRefreshComplete();
        } else if(eventCode == EventCode.HTTP_POST_UPDATE_ENTERPRISE_INFO) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_UPDATE_ENTERPRISE_INFO);
            UpdateEnterpriseInfoEvent updateEnterpriseInfoEvent = (UpdateEnterpriseInfoEvent) event;
            if(updateEnterpriseInfoEvent.isNetSuccess()) {
                if(updateEnterpriseInfoEvent.isOk()) {
                    if("ok".equals(updateEnterpriseInfoEvent.getResult())) {
                        toastManager.show(R.string.update_enterpriseInfo_success);
                    }
                } else {
                    if(updateEnterpriseInfoEvent.getErrorObject() == null) {
                        toastManager.show(updateEnterpriseInfoEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(updateEnterpriseInfoEvent.getErrorObject()));
                    }
                }
            }
        }
    }

    @Override
    protected void onInitAttribute(ActivityBaseAttribute ba) {
        super.onInitAttribute(ba);
        ba.setHasNavigationBar(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK) {
            List list1 = data.getCharSequenceArrayListExtra("firstCategories");
            String industry = ((CategoryForCashierAppDown) list1.get(0)).getName();
            List list2 = data.getCharSequenceArrayListExtra("secondCategories");
            List<Long> categoryIds = new ArrayList<Long>();
            for(int i=0;i<list2.size();i++) {
                if(list2.get(i) != null) {
                    if(i == 0) {
                        industry += "：" + ((CategoryForCashierAppDown) list2.get(i)).getName();
                    } else {
                        industry += "/" + ((CategoryForCashierAppDown) list2.get(i)).getName();
                    }
                    categoryIds.add(((CategoryForCashierAppDown) list2.get(i)).getId());
                }
            }
            btn_in_enterpriseManagerActivity_of_industry.setText(industry);
            enterpriseForCashierAppUp.setCategory1Id(((CategoryForCashierAppDown) list1.get(0)).getId());
            enterpriseForCashierAppUp.setCategory2Ids(categoryIds);
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

    public static void lunch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, EnterpriseManagerActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, EnterpriseManagerActivity.class);
            activity.startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void OnRecyclerViewItemClicked(int position) {
        ShopForCashierAppDown shopForCashierAppDown = (ShopForCashierAppDown) shopListAdapter.getItem(position);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        loadMoreOrRefresh = false;
        initCommonPagerUp();
        queryShopList(false);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        loadMoreOrRefresh = true;
        initCommonPagerUp();
        queryShopList(false);
    }
}

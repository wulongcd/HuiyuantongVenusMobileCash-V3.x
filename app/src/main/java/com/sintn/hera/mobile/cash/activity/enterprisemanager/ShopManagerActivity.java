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
import com.sintn.hera.mobile.cash.adapter.CashierListAdapter;
import com.sintn.hera.mobile.cash.entity.down.CategoryForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.down.ShopForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.ShopManagerAccountForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.up.ShopForCashierAppUp;
import com.sintn.hera.mobile.cash.entity.up.ShopManagerAccountForCashierAppQueryUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.AddShopEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryShopCashierListEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.UpdateShopInfoEvent;
import com.sintn.hera.mobile.cash.listener.OnRecyclerViewItemClickListener;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.utils.common.PartternUtil;
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

public class ShopManagerActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2, OnRecyclerViewItemClickListener {
    //查询条件-需求页
    private int page = 0;
    //查询条件-默认页大小
    private int size = 12;
    // 默认刷新,用于判断当前操作是刷新还是加载更多
    private boolean loadMoreOrRefresh = false;
    //已经加载数量
    private long loadSize = 0;
    private TextView tv_in_shopManagerActivity_of_title = null;
    private TextView tv_in_shopManagerActivity_of_shopInfo = null;
    private TextView tv_in_shopManagerActivity_of_cashierList = null;
    private TextView tv_in_shopManagerActivity_of_shopNumber = null;
    private TextView tv_in_shopManagerActivity_of_shopName = null;
    private TextView tv_in_shopManagerActivity_of_customerService = null;
    private TextView tv_in_shopManagerActivity_of_address = null;
    private TextView tv_in_shopManagerActivity_of_detailedAddress = null;
    private EditText et_in_shopManagerActivity_of_shopNumber = null;
    private EditText et_in_shopManagerActivity_of_shopName = null;
    private EditText et_in_shopManagerActivity_of_customerService = null;
    private Button btn_in_shopManagerActivity_of_address = null;
    private EditText et_in_shopManagerActivity_of_detailedAddress = null;
    private Button btn_in_shopManagerActivity_of_back = null;
    private Button btn_in_shopManagerActivity_of_submit = null;
    private FloatingActionButton fBtn_in_shopManagerActivity_of_add = null;
    private ImageView iv_in_shopManagerActivity_of_shopInfo = null;
    private ImageView iv_in_shopManagerActivity_of_cashierList = null;
    private PtrRecyclerView prv_in_shopManagerActivity_for_list = null;
    private RelativeLayout rl_in_shopManagerActivity_of_shopInfo = null;
    private RelativeLayout rl_in_shopManagerActivity_of_cashierList = null;
    private LinearLayout ll_in_shopManagerActivity_of_shopNumber = null;
    private LinearLayout ll_in_shopManagerActivity_of_shopName = null;
    private LinearLayout ll_in_shopManagerActivity_of_customerService = null;
    private LinearLayout ll_in_shopManagerActivity_of_address = null;
    private LinearLayout ll_in_shopManagerActivity_of_detailedAddress = null;
    private ShopManagerAccountForCashierAppQueryUp shopManagerAccountForCashierAppQueryUp = null;
    private CashierListAdapter<ShopManagerAccountForCashierAppDown> cashierListAdapter = null;
    private ShopForCashierAppUp shopForCashierAppUp = null;
    private int mode = ShopEditMode.MODE_ADD;
    private ShopForCashierAppDown shopForCashierAppDown = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();
        tv_in_shopManagerActivity_of_title = (TextView) findViewById(R.id.tv_normal_title_for_show_title);
        btn_in_shopManagerActivity_of_back = (Button) findViewById(R.id.btn_normal_title_for_back);
        btn_in_shopManagerActivity_of_submit = (Button) findViewById(R.id.btn_normal_title_for_right);
        fBtn_in_shopManagerActivity_of_add = (FloatingActionButton) findViewById(R.id.fBtn_in_shopManagerActivity_of_add);

        rl_in_shopManagerActivity_of_shopInfo = (RelativeLayout) findViewById(R.id.rl_in_shopManagerActivity_of_shopInfo);
        tv_in_shopManagerActivity_of_shopInfo = (TextView) rl_in_shopManagerActivity_of_shopInfo.findViewById(R.id.tv_in_managerActivity_item_of_name);
        iv_in_shopManagerActivity_of_shopInfo = (ImageView) rl_in_shopManagerActivity_of_shopInfo.findViewById(R.id.iv_in_managerActivity_item_of_logo);

        rl_in_shopManagerActivity_of_cashierList = (RelativeLayout) findViewById(R.id.rl_in_shopManagerActivity_of_cashierList);
        tv_in_shopManagerActivity_of_cashierList = (TextView) rl_in_shopManagerActivity_of_cashierList.findViewById(R.id.tv_in_managerActivity_item_of_name);
        iv_in_shopManagerActivity_of_cashierList = (ImageView) rl_in_shopManagerActivity_of_cashierList.findViewById(R.id.iv_in_managerActivity_item_of_logo);

        ll_in_shopManagerActivity_of_shopNumber = (LinearLayout) findViewById(R.id.ll_in_shopManagerActivity_of_shopNumber);
        tv_in_shopManagerActivity_of_shopNumber = (TextView) ll_in_shopManagerActivity_of_shopNumber.findViewById(R.id.tv_in_infoActivity_item);
        et_in_shopManagerActivity_of_shopNumber = (EditText) ll_in_shopManagerActivity_of_shopNumber.findViewById(R.id.et_in_infoActivity_item);

        ll_in_shopManagerActivity_of_shopName = (LinearLayout) findViewById(R.id.ll_in_shopManagerActivity_of_shopName);
        tv_in_shopManagerActivity_of_shopName = (TextView) ll_in_shopManagerActivity_of_shopName.findViewById(R.id.tv_in_infoActivity_item);
        et_in_shopManagerActivity_of_shopName = (EditText) ll_in_shopManagerActivity_of_shopName.findViewById(R.id.et_in_infoActivity_item);

        ll_in_shopManagerActivity_of_customerService = (LinearLayout) findViewById(R.id.ll_in_shopManagerActivity_of_customerService);
        tv_in_shopManagerActivity_of_customerService = (TextView) ll_in_shopManagerActivity_of_customerService.findViewById(R.id.tv_in_infoActivity_item);
        et_in_shopManagerActivity_of_customerService = (EditText) ll_in_shopManagerActivity_of_customerService.findViewById(R.id.et_in_infoActivity_item);

        ll_in_shopManagerActivity_of_address = (LinearLayout) findViewById(R.id.ll_in_shopManagerActivity_of_address);
        tv_in_shopManagerActivity_of_address = (TextView) ll_in_shopManagerActivity_of_address.findViewById(R.id.tv_in_editItem_of_industry);
        btn_in_shopManagerActivity_of_address = (Button) ll_in_shopManagerActivity_of_address.findViewById(R.id.btn_in_editItem_of_industry);

        ll_in_shopManagerActivity_of_detailedAddress = (LinearLayout) findViewById(R.id.ll_in_shopManagerActivity_of_detailedAddress);
        tv_in_shopManagerActivity_of_detailedAddress = (TextView) ll_in_shopManagerActivity_of_detailedAddress.findViewById(R.id.tv_in_infoActivity_item);
        et_in_shopManagerActivity_of_detailedAddress = (EditText) ll_in_shopManagerActivity_of_detailedAddress.findViewById(R.id.et_in_infoActivity_item);

        if(getIntent().hasExtra("shopForCashierAppDown")) {
            shopForCashierAppDown = getIntent().getParcelableExtra("shopForCashierAppDown");
            mode = ShopEditMode.MODE_UPDATE;
            cashierListAdapter = new CashierListAdapter<ShopManagerAccountForCashierAppDown>(this, shopForCashierAppDown.getName());
            shopManagerAccountForCashierAppQueryUp = new ShopManagerAccountForCashierAppQueryUp();
        }
        shopForCashierAppUp = new ShopForCashierAppUp();
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
        tv_in_shopManagerActivity_of_title.setText(R.string.string_of_shopManager);
        btn_in_shopManagerActivity_of_submit.setText(R.string.string_of_submit);

        tv_in_shopManagerActivity_of_shopInfo.setText(R.string.string_of_shopInfo);
        iv_in_shopManagerActivity_of_shopInfo.setBackgroundResource(R.drawable.shop_info);
        tv_in_shopManagerActivity_of_cashierList.setText(R.string.string_of_cashierList);
        iv_in_shopManagerActivity_of_cashierList.setBackgroundResource(R.drawable.cashier_list);

        fBtn_in_shopManagerActivity_of_add.setOnClickListener(this);
        btn_in_shopManagerActivity_of_back.setOnClickListener(this);
        btn_in_shopManagerActivity_of_submit.setOnClickListener(this);
        btn_in_shopManagerActivity_of_address.setOnClickListener(this);

        ll_in_shopManagerActivity_of_shopNumber.setBackgroundColor(getResources().getColor(R.color.white));
        ll_in_shopManagerActivity_of_shopName.setBackgroundColor(getResources().getColor(R.color.white));
        ll_in_shopManagerActivity_of_customerService.setBackgroundColor(getResources().getColor(R.color.white));
        ll_in_shopManagerActivity_of_detailedAddress.setBackgroundColor(getResources().getColor(R.color.white));
        ll_in_shopManagerActivity_of_address.setBackgroundColor(getResources().getColor(R.color.white));
        tv_in_shopManagerActivity_of_shopNumber.setText(R.string.string_of_shopNumber);
        tv_in_shopManagerActivity_of_shopName.setText(R.string.string_of_shopName);
        tv_in_shopManagerActivity_of_customerService.setText(R.string.string_of_customerService);
        tv_in_shopManagerActivity_of_detailedAddress.setText(R.string.string_of_detailAddress);
        tv_in_shopManagerActivity_of_address.setText(R.string.string_of_shopAddress);
        if(mode == ShopEditMode.MODE_ADD) {
            et_in_shopManagerActivity_of_shopNumber.setHint(R.string.hint_of_shopNumber);
            et_in_shopManagerActivity_of_shopName.setHint(R.string.hint_of_shopName);
            et_in_shopManagerActivity_of_customerService.setHint(R.string.hint_of_customerService);
            et_in_shopManagerActivity_of_detailedAddress.setHint(R.string.string_of_enterAddress);
            btn_in_shopManagerActivity_of_address.setHint(R.string.hint_of_choose_shopAddress);
        } else {
            cashierListAdapter.setOnRecyclerViewItemClickListener(this);
            prv_in_shopManagerActivity_for_list.setAdapter(cashierListAdapter);
            prv_in_shopManagerActivity_for_list.setMode(PullToRefreshBase.Mode.BOTH);
            LinearLayoutManager manager = new LinearLayoutManager(this);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            prv_in_shopManagerActivity_for_list.setLayoutManager(manager);
            prv_in_shopManagerActivity_for_list.setOnRefreshListener(this);

            et_in_shopManagerActivity_of_shopNumber.setHint("");
            et_in_shopManagerActivity_of_shopName.setHint("");
            et_in_shopManagerActivity_of_customerService.setHint("");
            et_in_shopManagerActivity_of_detailedAddress.setHint("");
            btn_in_shopManagerActivity_of_address.setHint("");
            initShopManagerAccountForCashierAppQueryUp();
            queryCashierList(true);
        }
    }

    /**
     * 初始化店铺收银员列表查询实体
     */
    private void initShopManagerAccountForCashierAppQueryUp() {
        if(loadMoreOrRefresh) {
            page++;
        } else {
            page = 0;
            loadSize = 0;
        }
        shopManagerAccountForCashierAppQueryUp.setPage(page);
        shopManagerAccountForCashierAppQueryUp.setSize(size);
    }

    /**
     * 初始化店铺信息更新实体
     */
    private boolean initShopForCashierAppUp() {
        if(et_in_shopManagerActivity_of_shopNumber.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.shopNumber_is_null);
            return false;
        }
        if(et_in_shopManagerActivity_of_shopName.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.shopName_is_null);
            return false;
        }
        if(et_in_shopManagerActivity_of_customerService.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.customerService_is_null);
            return false;
        }
        if(PartternUtil.isPhone(et_in_shopManagerActivity_of_customerService.getText().toString().trim())) {
            toastManager.show(R.string.toast_phone_not_in_patter);
            return false;
        }
        if(btn_in_shopManagerActivity_of_address.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.address_is_null);
            return false;
        }
        if(et_in_shopManagerActivity_of_detailedAddress.getText().toString().trim().length() <=0) {
            toastManager.show(R.string.address_is_null);
            return false;
        }
        shopForCashierAppUp.setCode(et_in_shopManagerActivity_of_shopNumber.getText().toString().trim());
        shopForCashierAppUp.setName(et_in_shopManagerActivity_of_shopName.getText().toString().trim());
        shopForCashierAppUp.setPhone(et_in_shopManagerActivity_of_shopNumber.getText().toString().trim());
        shopForCashierAppUp.setAddress(et_in_shopManagerActivity_of_detailedAddress.getText().toString().trim());
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
                ProvinceListActivity.launch(this);
                break;
            case R.id.btn_normal_title_for_right:
                if(initShopForCashierAppUp()) {
                    if(mode == ShopEditMode.MODE_ADD) {
                        addShop(true);
                    }else if(mode == ShopEditMode.MODE_UPDATE) {
                        updateShopInfo(true);
                    }
                }
                break;
            case R.id.fBtn_in_shopManagerActivity_of_add:
                CashierInfoActivity.lunch(this);
                break;
            default:
                break;
        }
    }

    /**
     * 更新企业基本信息
     * @param isShow 是否显示加载动画
     */
    private void updateShopInfo(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_UPDATE_SHOP_INFO);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_UPDATE_SHOP_INFO, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_UPDATE_SHOP_INFO, 0, URLUtils.URL_POST_UPDATE_SHOP_INFO);
    }

    /**
     * 查询收银员列表
     * @param isShow 是否显示加载动画
     */
    private void queryCashierList(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_QUERY_SHOP_CASHIER_LIST);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_QUERY_SHOP_CASHIER_LIST, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_QUERY_SHOP_CASHIER_LIST, 0, URLUtils.URL_POST_QUERY_SHOP_CASHIER_LIST, shopManagerAccountForCashierAppQueryUp);
    }

    /**
     * 添加店铺
     * @param isShow 是否显示加载动画
     */
    private void addShop(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_ADD_SHOP);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_ADD_SHOP, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_ADD_SHOP, 0, URLUtils.URL_POST_ADD_SHOP, shopForCashierAppUp);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        super.onEventRunEnd(event);
        if(eventCode == EventCode.HTTP_POST_QUERY_SHOP_CASHIER_LIST) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_QUERY_SHOP_CASHIER_LIST);
            QueryShopCashierListEvent queryShopCashierListEvent = (QueryShopCashierListEvent) event;
            if(queryShopCashierListEvent.isNetSuccess()) {
                if(queryShopCashierListEvent.isOk()) {
                    if(queryShopCashierListEvent.getResult() != null) {
                        CommonPagerDown<ShopManagerAccountForCashierAppDown> commonPagerDown = queryShopCashierListEvent.getResult();
                        List<ShopManagerAccountForCashierAppDown> shopManagerAccountForCashierAppDowns = commonPagerDown.getList();
                        if(loadMoreOrRefresh) {
                            cashierListAdapter.addAllItem(shopManagerAccountForCashierAppDowns);
                        } else {
                            cashierListAdapter.replaceAll(shopManagerAccountForCashierAppDowns);
                        }
                        loadSize += shopManagerAccountForCashierAppDowns.size();
                        if(loadSize < commonPagerDown.getTotalCount()) {
                            prv_in_shopManagerActivity_for_list.setMode(PullToRefreshBase.Mode.BOTH);
                        } else {
                            prv_in_shopManagerActivity_for_list.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                        }
                    }
                } else {
                    if(queryShopCashierListEvent.getErrorObject() == null) {
                        toastManager.show(queryShopCashierListEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(queryShopCashierListEvent.getErrorObject()));
                    }
                }
            }
            prv_in_shopManagerActivity_for_list.onRefreshComplete();
        } else if(eventCode == EventCode.HTTP_POST_UPDATE_SHOP_INFO) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_UPDATE_SHOP_INFO);
            UpdateShopInfoEvent updateShopInfoEvent = (UpdateShopInfoEvent) event;
            if(updateShopInfoEvent.isNetSuccess()) {
                if(updateShopInfoEvent.isOk()) {
                    if("ok".equals(updateShopInfoEvent.getResult())) {
                        toastManager.show(R.string.update_shopInfo_success);
                        this.finish();
                    }
                } else {
                    if(updateShopInfoEvent.getErrorObject() == null) {
                        toastManager.show(updateShopInfoEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(updateShopInfoEvent.getErrorObject()));
                    }
                }
            }
        } else if(eventCode == EventCode.HTTP_POST_ADD_SHOP) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_ADD_SHOP);
            AddShopEvent addShopEvent = (AddShopEvent) event;
            if(addShopEvent.isNetSuccess()) {
                if(addShopEvent.isOk()) {
                    if("ok".equals(addShopEvent.getResult())) {
                        toastManager.show(R.string.add_shop_success);
                        this.finish();
                    }
                } else {
                    if(addShopEvent.getErrorObject() == null) {
                        toastManager.show(addShopEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(addShopEvent.getErrorObject()));
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
            btn_in_shopManagerActivity_of_address.setText(industry);
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

    public static void lunch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, ShopManagerActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, ShopManagerActivity.class);
            activity.startActivity(intent);
        }
    }

    public static void lunch(Activity activity, String shopForCashierAppDown) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, ShopManagerActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, ShopManagerActivity.class);
            intent.putExtra("shopForCashierAppDown", shopForCashierAppDown);
            activity.startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void OnRecyclerViewItemClicked(int position) {
        ShopForCashierAppDown shopForCashierAppDown = (ShopForCashierAppDown) cashierListAdapter.getItem(position);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        loadMoreOrRefresh = false;
        initShopManagerAccountForCashierAppQueryUp();
        queryCashierList(false);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        loadMoreOrRefresh = true;
        initShopManagerAccountForCashierAppQueryUp();
        queryCashierList(false);
    }
    
    public static class ShopEditMode {
        public static int MODE_ADD = 0;
        public static int MODE_UPDATE = 1;
    }
}

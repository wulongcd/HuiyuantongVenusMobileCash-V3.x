package com.sintn.hera.mobile.cash.activity.main.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;

import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.adapter.fragment.OrderQueryRecycleListAdapter;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.down.OrderForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.TotalMoneyForSimpleCashierDown;
import com.sintn.hera.mobile.cash.entity.up.OrderForSimpleCashierQueryUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QueryQrcodeOrderEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QueryQrcodeOrderTotalEvent;
import com.sintn.hera.mobile.cash.listener.OnRecyclerViewItemClickListener;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.DateUtil;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.widget.pullrecycle.PtrRecyclerView;
import com.sintn.hera.mobile.cash.widget.pullrecycle.PullToRefreshBase;

import java.util.Date;

public class CashOrderFragment extends BaseMainFragment implements SwipeRefreshLayout.OnRefreshListener, PullToRefreshBase.OnRefreshListener2, OnRecyclerViewItemClickListener {


    //查询条件-需求页
    private int page = 0;
    //查询条件-默认页大小
    private int size = 12;
    // 默认刷新,用于判断当前操作是刷新还是加载更多
    private boolean loadMoreOrRefresh = false;
    //已经加载会员数量
    private long loadCardSize = 0;
    //总共会员数量
    private long totalCardSize = 0;
    private boolean isLoadMoreOrRefresh = false;
    private OrderForSimpleCashierQueryUp orderForSimpleCashierQueryUp = null;

    private LinearLayout ll_refresh_in_maincativity_of_fragment_float_order_for_root;
    private PtrRecyclerView rc_in_maincativity_of_fragment_float_order_for_list;
    private OrderQueryRecycleListAdapter orderQueryRecycleListAdapter = null;

    private LinearLayoutManager manager;
    //时间选择
    private Button btn_in_fragment_for_date_start;
    private Button btn_in_fragment_for_date_end;
    private boolean isChoiceWhichDate;
    private TotalMoneyForSimpleCashierDown data = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.mainactivity_fragment_for_cash_order, container, false);
        ll_refresh_in_maincativity_of_fragment_float_order_for_root = (LinearLayout) rootView.findViewById(R.id.ll_refresh_in_maincativity_of_fragment_float_order_for_root);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        addCallbackEventListener(EventCode.CALLBACK_OF_QRCODE_PAY_SUCESS);
        addCallbackEventListener(EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_PRESS_CALLBACK);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();

        rc_in_maincativity_of_fragment_float_order_for_list = (PtrRecyclerView) ll_refresh_in_maincativity_of_fragment_float_order_for_root.findViewById(R.id.rc_in_maincativity_of_fragment_float_order_for_list);

        orderQueryRecycleListAdapter = new OrderQueryRecycleListAdapter(mainActivity);
        orderQueryRecycleListAdapter.setOnRecyclerViewItemClickListener(this);
        orderForSimpleCashierQueryUp = new OrderForSimpleCashierQueryUp();
        orderForSimpleCashierQueryUp.setSize(size);
        orderForSimpleCashierQueryUp.setPage(page);
        btn_in_fragment_for_date_start = (Button) ll_refresh_in_maincativity_of_fragment_float_order_for_root.findViewById(R.id.btn_in_fragment_for_date_start);
        btn_in_fragment_for_date_end = (Button) ll_refresh_in_maincativity_of_fragment_float_order_for_root.findViewById(R.id.btn_in_fragment_for_date_end);

        btn_in_fragment_for_date_start.setOnClickListener(this);
        btn_in_fragment_for_date_end.setOnClickListener(this);
        orderForSimpleCashierQueryUp.setBeginDate(DateUtil.stringToDate(DateUtil.getDateShort(DateUtil.DATE_STYLE1), DateUtil.DATE_STYLE1));
        orderForSimpleCashierQueryUp.setEndDate(DateUtil.stringToDate(DateUtil.getDateShort(DateUtil.DATE_STYLE1), DateUtil.DATE_STYLE1));

        rc_in_maincativity_of_fragment_float_order_for_list.setOnRefreshListener(this);
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();

        //just can loadin UIthread
        rc_in_maincativity_of_fragment_float_order_for_list.setMode(PullToRefreshBase.Mode.BOTH);
        manager = new LinearLayoutManager(mainActivity);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        btn_in_fragment_for_date_start.setText(DateUtil.getDateShort(DateUtil.DATE_STYLE1));
        btn_in_fragment_for_date_end.setText(DateUtil.getDateShort(DateUtil.DATE_STYLE1));
        rc_in_maincativity_of_fragment_float_order_for_list.setLayoutManager(manager);
        rc_in_maincativity_of_fragment_float_order_for_list.setAdapter(orderQueryRecycleListAdapter);

        queryOrderQueryTotalMoney(orderForSimpleCashierQueryUp);
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        data = null;
        page = 0;// 需求页
        size = 24;// 默认页大小
        loadMoreOrRefresh = false;// 默认刷新
        loadCardSize = 0;// 已经加载会员数量
        totalCardSize = 0;// 总共会员数量
        orderForSimpleCashierQueryUp.setPage(page);
        queryOrderQueryTotalMoney(orderForSimpleCashierQueryUp);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        loadMoreOrRefresh = true;
        page++;
        orderForSimpleCashierQueryUp.setPage(page);
        queryCancleOrderRecords(orderForSimpleCashierQueryUp);
    }

    /**
     * @param orderForSimpleCashierQueryUp
     */
    protected void queryCancleOrderRecords(OrderForSimpleCashierQueryUp orderForSimpleCashierQueryUp) {

        if (!isLoadMoreOrRefresh) {
            AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_ORDER_QUERY, this, true);
            AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_ORDER_QUERY, 0, URLUtils.URL_ORDER_QUERY, orderForSimpleCashierQueryUp);
            isLoadMoreOrRefresh = true;
        }
    }

    /**
     * @param orderForSimpleCashierQueryUp
     */
    protected void queryOrderQueryTotalMoney(OrderForSimpleCashierQueryUp orderForSimpleCashierQueryUp) {
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_ORDER_QUERYTOTALMONEY, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_ORDER_QUERYTOTALMONEY, 0, URLUtils.URL_ORDER_QUERYTOTALMONEY, orderForSimpleCashierQueryUp);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        super.onEventRunEnd(event);
        if (EventCode.HTTP_POST_ORDER_QUERYTOTALMONEY == eventCode) {
            final QueryQrcodeOrderTotalEvent queryQrcodeOrderTotalEvent = (QueryQrcodeOrderTotalEvent) event;
            if (queryQrcodeOrderTotalEvent.isNetSuccess()) {
                if (queryQrcodeOrderTotalEvent.isOk()) {
                    if (queryQrcodeOrderTotalEvent.getData() != null) {
                        orderQueryRecycleListAdapter.removeAllItem(orderQueryRecycleListAdapter.getlistObject());
                        data = queryQrcodeOrderTotalEvent.getData();
                        queryCancleOrderRecords(orderForSimpleCashierQueryUp);
                    }
                } else {
                    if (queryQrcodeOrderTotalEvent.getErrorObject() == null) {
                        mainActivity.toastManager.show(queryQrcodeOrderTotalEvent.getStrHttpResult());
                    } else {
                        mainActivity.toastManager.show(ErrorObject.formatError(queryQrcodeOrderTotalEvent.getErrorObject()));
                    }
                    rc_in_maincativity_of_fragment_float_order_for_list.onRefreshComplete();
                }
            } else {
                rc_in_maincativity_of_fragment_float_order_for_list.onRefreshComplete();
            }
            return;
        } else if (EventCode.HTTP_POST_ORDER_QUERY == eventCode) {
            isLoadMoreOrRefresh = false;
            final QueryQrcodeOrderEvent queryQrcodeOrderEvent = (QueryQrcodeOrderEvent) event;
            if (queryQrcodeOrderEvent.isNetSuccess()) {
                if (queryQrcodeOrderEvent.isOk()) {
                    if (queryQrcodeOrderEvent.getData() != null && queryQrcodeOrderEvent.getData().getList() != null) {
                        if (!loadMoreOrRefresh) {
                            orderQueryRecycleListAdapter.addItem(new OrderForCashierAppDown(data), false);
                            orderQueryRecycleListAdapter.addItem(new OrderForCashierAppDown(data), false);
                            orderQueryRecycleListAdapter.addAllItem(queryQrcodeOrderEvent.getData().getList(), false);
                        } else {
                            orderQueryRecycleListAdapter.addAllItem(queryQrcodeOrderEvent.getData().getList(), false);
                        }
                        loadCardSize += queryQrcodeOrderEvent.getData().getList().size();
                        orderQueryRecycleListAdapter.notifyDataSetChanged();
                        totalCardSize = queryQrcodeOrderEvent.getData().getTotalCount();
                        if (loadCardSize >= totalCardSize) {
                            rc_in_maincativity_of_fragment_float_order_for_list.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                        } else {
                            rc_in_maincativity_of_fragment_float_order_for_list.setMode(PullToRefreshBase.Mode.BOTH);
                        }
                    }
                } else {
                    if (queryQrcodeOrderEvent.getErrorObject() == null) {
                        mainActivity.toastManager.show(queryQrcodeOrderEvent.getStrHttpResult());
                    } else {
                        mainActivity.toastManager.show(ErrorObject.formatError(queryQrcodeOrderEvent.getErrorObject()));
                    }
                }
                rc_in_maincativity_of_fragment_float_order_for_list.onRefreshComplete();
            } else {
                rc_in_maincativity_of_fragment_float_order_for_list.onRefreshComplete();
            }
            return;
        } else if (EventCode.CALLBACK_OF_QRCODE_PAY_SUCESS == eventCode) {
            rc_in_maincativity_of_fragment_float_order_for_list.setRefreshing(true);
            onRefresh();
        } else if (EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_PRESS_CALLBACK == eventCode) {
            final MobileCashBaseCallbackEvent callbackEvent = (MobileCashBaseCallbackEvent) event;
            final Date a = (Date) callbackEvent.getReturnParam();
            if (!isChoiceWhichDate) {
                orderForSimpleCashierQueryUp.setBeginDate(a);
                btn_in_fragment_for_date_start.setText(DateUtil.dateToString(a, DateUtil.DATE_STYLE1));
                rc_in_maincativity_of_fragment_float_order_for_list.setRefreshing(true);
                onRefresh();
            } else {
                if (orderForSimpleCashierQueryUp.getBeginDate() != null) {
                    if (DateUtil.isADataAfterBData(orderForSimpleCashierQueryUp.getBeginDate(), a)) {
                        mainActivity.toastManager.show("结束时间不能小于开始时间");
                    } else {
                        orderForSimpleCashierQueryUp.setEndDate(a);
                        btn_in_fragment_for_date_end.setText(DateUtil.dateToString(a, DateUtil.DATE_STYLE1));
                        rc_in_maincativity_of_fragment_float_order_for_list.setRefreshing(true);
                        onRefresh();
                    }
                } else {
                    mainActivity.toastManager.show("请先设置开始时间");
                }
            }
            return;
        }
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (btn_in_fragment_for_date_start == v) {
            isChoiceWhichDate = false;
            DialogUtils.ShowNormalDateChoiceWithCallbackDialog(mainActivity, false);

        } else if (btn_in_fragment_for_date_end == v) {
            isChoiceWhichDate = true;
            DialogUtils.ShowNormalDateChoiceWithCallbackDialog(mainActivity, false);
        }
    }

    @Override
    public void OnRecyclerViewItemClicked(int position) {

    }

    @Override
    public void onDestroy() {
        removeCallbackEventListener(EventCode.CALLBACK_OF_QRCODE_PAY_SUCESS);
        removeCallbackEventListener(EventCode.DIALOG_OF_NORMAL_CHOICE_DATE_PRESS_CALLBACK);
        super.onDestroy();
    }


}

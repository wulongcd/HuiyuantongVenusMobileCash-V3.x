package com.sintn.hera.mobile.cash.activity.enterprisemanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.entity.conast.CashierEditMode;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.up.ShopManagerAccountForCashierAppUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.AddShopCashierEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.UpdateShopCashierEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;

/**
 * @Desc: 企业管理界面
 * @com.sintn.hera.mobile.cash.activity.login
 * @HuiyuantongVenusWokerAssistant-V3.x
 * @LoginActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-8-4下午4:51:01
 */

public class CashierInfoActivity extends BaseActivity {
    private EditText et_in_cashierInfoActivity_of_name;
    private EditText et_in_cashierInfoActivity_of_account;
    private EditText et_in_cashierInfoActivity_of_pwd;
    private TextView tv_in_cashierInfoActivity_of_name;
    private TextView tv_in_cashierInfoActivity_of_account;
    private TextView tv_in_cashierInfoActivity_of_pwd;
    private TextView tv_in_cashierInfoActivity_of_title;
    private Button btn_in_cashierInfoActivity_of_back;
    private Button btn_in_cashierInfoActivity_of_submit;
    private ShopManagerAccountForCashierAppUp shopManagerAccountForCashierAppUp = null;
    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();
        Intent intent = getIntent();
        tv_in_cashierInfoActivity_of_title = (TextView) findViewById(R.id.tv_normal_title_for_show_title);
        btn_in_cashierInfoActivity_of_back = (Button) findViewById(R.id.btn_normal_title_for_back);
        btn_in_cashierInfoActivity_of_submit = (Button) findViewById(R.id.btn_normal_title_for_right);

        LinearLayout ll_in_cashierInfoActivity_of_name = (LinearLayout) findViewById(R.id.ll_in_cashierInfoActivity_of_name);
        tv_in_cashierInfoActivity_of_name = (TextView) ll_in_cashierInfoActivity_of_name.findViewById(R.id.tv_in_infoActivity_item);
        et_in_cashierInfoActivity_of_name = (EditText) ll_in_cashierInfoActivity_of_name.findViewById(R.id.et_in_infoActivity_item);

        LinearLayout ll_in_cashierInfoActivity_of_account = (LinearLayout) findViewById(R.id.ll_in_cashierInfoActivity_of_name);
        tv_in_cashierInfoActivity_of_account = (TextView) ll_in_cashierInfoActivity_of_account.findViewById(R.id.tv_in_infoActivity_item);
        et_in_cashierInfoActivity_of_account = (EditText) ll_in_cashierInfoActivity_of_account.findViewById(R.id.et_in_infoActivity_item);

        LinearLayout ll_in_cashierInfoActivity_of_pwd = (LinearLayout) findViewById(R.id.ll_in_cashierInfoActivity_of_name);
        tv_in_cashierInfoActivity_of_pwd = (TextView) ll_in_cashierInfoActivity_of_pwd.findViewById(R.id.tv_in_infoActivity_item);
        et_in_cashierInfoActivity_of_pwd = (EditText) ll_in_cashierInfoActivity_of_pwd.findViewById(R.id.et_in_infoActivity_item);

        mode = getIntent().getIntExtra("mode", CashierEditMode.ADD);
        if(mode == CashierEditMode.ADD) {
            shopManagerAccountForCashierAppUp = new ShopManagerAccountForCashierAppUp();
        } else {
            shopManagerAccountForCashierAppUp = (ShopManagerAccountForCashierAppUp) getIntent().getParcelableExtra("shopManagerAccountForCashierAppUp");
        }
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
        tv_in_cashierInfoActivity_of_title.setText(R.string.string_of_cashierInfo);
        tv_in_cashierInfoActivity_of_name.setText(R.string.string_of_name);
        tv_in_cashierInfoActivity_of_account.setText(R.string.string_of_account);
        tv_in_cashierInfoActivity_of_pwd.setText(R.string.string_of_pwd);
        et_in_cashierInfoActivity_of_name.setText(R.string.hint_string_of_name);
        et_in_cashierInfoActivity_of_account.setText(R.string.hint_string_of_account);
        et_in_cashierInfoActivity_of_pwd.setText(R.string.hint_string_of_pwd);
        btn_in_cashierInfoActivity_of_submit.setText(R.string.string_of_submit);
        btn_in_cashierInfoActivity_of_back.setOnClickListener(this);
        btn_in_cashierInfoActivity_of_submit.setOnClickListener(this);
        if(mode == CashierEditMode.UPDATE) {
            et_in_cashierInfoActivity_of_name.setText(shopManagerAccountForCashierAppUp.getName());
            et_in_cashierInfoActivity_of_account.setText(shopManagerAccountForCashierAppUp.getUsername());
            et_in_cashierInfoActivity_of_pwd.setText(R.string.hint_pwd);
        }
    }

    /**
     * 初始化添加或更新收银员实体
     */
    private void initShopManagerAccountForCashierAppUp() {
        if(et_in_cashierInfoActivity_of_name.getText().toString().toString().length() <= 0) {
            toastManager.show(R.string.name_is_null);
            return;
        }
        if(et_in_cashierInfoActivity_of_account.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.account_is_null);
            return;
        }
        if(et_in_cashierInfoActivity_of_pwd.getText().toString().trim().length() <= 0) {
            toastManager.show(R.string.pwd_is_null);
            return;
        }
        shopManagerAccountForCashierAppUp.setPassword(et_in_cashierInfoActivity_of_pwd.getText().toString().trim());
        shopManagerAccountForCashierAppUp.setName(et_in_cashierInfoActivity_of_name.getText().toString().trim());
        shopManagerAccountForCashierAppUp.setUsername(et_in_cashierInfoActivity_of_account.getText().toString().trim());
    }

    /**
     * 添加收银员
     * @param isShow 是否加载动画
     */
    protected void submitCashierInfo(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_ADD_SHOP_CASHIER);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_ADD_SHOP_CASHIER, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_ADD_SHOP_CASHIER, 0, URLUtils.URL_POST_ADD_SHOP_CASHIER, shopManagerAccountForCashierAppUp);
    }

    /**
     * 更新收银员信息
     * @param isShow 是否加载动画
     */
    protected void updateCashierInfo(boolean isShow) {
        if(isShow) {
            DialogUtils.showLoading(this, EventCode.HTTP_POST_UPDATE_SHOP_CASHIER);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_UPDATE_SHOP_CASHIER, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_UPDATE_SHOP_CASHIER, 0, URLUtils.URL_POST_UPDATE_SHOP_CASHIER, shopManagerAccountForCashierAppUp);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
        switch (clickedViewId) {
            case R.id.btn_normal_title_for_back:
                onBackPressed();
                break;
            case R.id.btn_normal_title_for_right:
                initShopManagerAccountForCashierAppUp();
                if(mode == CashierEditMode.UPDATE) {
                    updateCashierInfo(true);
                } else {
                    submitCashierInfo(true);
                }
                break;
        }
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        super.onEventRunEnd(event);
        if(eventCode == EventCode.HTTP_POST_UPDATE_SHOP_CASHIER) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_UPDATE_SHOP_CASHIER);
            UpdateShopCashierEvent updateShopCashierEvent = (UpdateShopCashierEvent) event;
            if(updateShopCashierEvent.isNetSuccess()) {
                if(updateShopCashierEvent.isOk()) {
                    if(("ok").equals(updateShopCashierEvent.getResult())) {
                        toastManager.show(R.string.update_cashierInfo_success);
                    }
                } else {
                    if(updateShopCashierEvent.getErrorObject() == null) {
                        toastManager.show(updateShopCashierEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(updateShopCashierEvent.getErrorObject()));
                    }
                }
            }
        } else if(eventCode == EventCode.HTTP_POST_ADD_SHOP_CASHIER) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_ADD_SHOP_CASHIER);
            AddShopCashierEvent addShopCashierEvent = (AddShopCashierEvent) event;
            if(addShopCashierEvent.isNetSuccess()) {
                if(addShopCashierEvent.isOk()) {
                    if(("ok").equals(addShopCashierEvent.getResult())) {
                        toastManager.show(R.string.add_cashierInfo_success);
                    }
                } else {
                    if(addShopCashierEvent.getErrorObject() == null) {
                        toastManager.show(addShopCashierEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(addShopCashierEvent.getErrorObject()));
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
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

    public static void lunch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, CashierInfoActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, CashierInfoActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static void lunch(Activity activity, int mode) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, CashierInfoActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, CashierInfoActivity.class);
            intent.putExtra("mode", mode);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    public static void lunch(Activity activity, int mode, ShopManagerAccountForCashierAppUp shopManagerAccountForCashierAppUp) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, CashierInfoActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, CashierInfoActivity.class);
            intent.putExtra("mode", mode);
            intent.putExtra("shopManagerAccountForCashierAppUp", shopManagerAccountForCashierAppUp);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.sintn.hera.mobile.cash.activity.login;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.activity.main.MainActivity;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.down.StaffLoginDown;
import com.sintn.hera.mobile.cash.entity.up.LoginForSimpleCashierUp;
import com.sintn.hera.mobile.cash.entity.up.LoginInfoUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.MoblieCashLoginUpEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.widget.materialdesign.views.ButtonFlat;

/**
 * @Desc: 登录界面
 * @com.sintn.hera.mobile.cash.activity.login
 * @HuiyuantongVenusWokerAssistant-V3.x
 * @LoginActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-8-4下午4:51:01
 */

public class LoginActivity extends BaseActivity {
    private EditText edtPassword;
    private TextView edtUsername;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();
        Intent intent = getIntent();
        edtUsername = (TextView) findViewById(R.id.etName);
        edtPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
        if (clickedViewId == R.id.btnLogin) {
            String pwd = edtPassword.getText().toString().trim();
            String username = edtUsername.getText().toString().trim();
            if (pwd.length() <= 0) {
                toastManager.show(R.string.toast_password_null);
            } else if (pwd.length() < 6) {
                toastManager.show(R.string.pwd_is_short);
            } else {
                login(username, pwd);
            }
        } else if(clickedViewId == R.id.btnRegister) {
            RegisterActivity.lunch(this);
        }
    }

    @Override
    protected void onInitAttribute(ActivityBaseAttribute ba) {
        super.onInitAttribute(ba);
        ba.setHasNavigationBar(false);
    }


    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        super.onEventRunEnd(event);
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

    public static void launch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, LoginActivity.class)) {
            Intent intent = new Intent();
            intent.setClass(activity, LoginActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.sintn.hera.mobile.cash.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.activity.main.ChoiceServerActivity;
import com.sintn.hera.mobile.cash.activity.main.MainActivity;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;

/**
 * @Desc: 首屏
 * @com.sintn.hera.mobile.cash.activity.login
 * @HuiyuantongVenusWokerAssistant-V3.x
 * @StartActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-24下午2:51:11
 */
public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
        BaseApplication.startLocation();
        if (BaseApplication.isNowTest()) {
			ChoiceServerActivity.launch(this);
        } else {
            loading();
        }
    }

    protected void loading() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    if (BaseApplication.isLogined()) {
                        MainActivity.launch(StartActivity.this);
                    } else {
                        LoginActivity.launch(StartActivity.this);
                    }

                }
            }
        }).start();
    }

    /**
     * 检测本地状态跳转
     */
    protected void checkAndJump() {
        MainActivity.launch(StartActivity.this);
        if (!BaseApplication.unUseVerison()) {
            if (BaseApplication.isLogined()) {
                MainActivity.launch(StartActivity.this);
            } else {
                LoginActivity.launch(StartActivity.this);
            }
        } else {
            // UpdateSoftActivity.launch(this);
        }
         finish();
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        super.onEventRunEnd(event);
        if (eventCode == EventCode.CALLBACK_OF_CHOICESERVER_OK) {
            URLUtils.initURServer((String) ((MobileCashBaseCallbackEvent) event).getReturnParam());
            loading();
        }
    }

    @Override
    protected void onInitAttribute(ActivityBaseAttribute ba) {
        super.onInitAttribute(ba);
        ba.setHasNavigationBar(false);
    }

    public static void launch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, LoginActivity.class)) {
            Intent intent = new Intent(activity, LoginActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.sintn.hera.mobile.cash.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.widget.circleprogress.CircleProgressView;
import com.sintn.hera.mobile.cash.widget.view.ProgressWheel;

import org.w3c.dom.Text;

public class SoftWareUpdateActivity extends BaseActivity {
    private ProgressWheel whell_in_softwareupdateactivity_for_defaultloading;

    private LinearLayout ll_in_softwareupdateactivity_for_tips;
    private TextView tv_in_softwareupdateactivity_for_tips;

    private LinearLayout ll_in_softwareupdateactivity_for_showdownloading;
    private CircleProgressView wwv_in_softwareupdateactivity_for_showdownloading;

    private LinearLayout ll_in_softwareupdateactivity_for_bottom;
    private LinearLayout ll_in_softwareupdateactivity_for_cancle;
    private FloatingActionButton flb_in_softwareupdateactivity_for_cancle;
    private LinearLayout ll_in_softwareupdateactivity_for_sure;
    private FloatingActionButton flb_in_softwareupdateactivity_for_sure;

    private float mPercent;

    private Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnInitUiAndData() {
        // TODO Auto-generated method stub
        super.OnInitUiAndData();

        whell_in_softwareupdateactivity_for_defaultloading = (ProgressWheel) findViewById(R.id.whell_in_softwareupdateactivity_for_defaultloading);

        ll_in_softwareupdateactivity_for_tips = (LinearLayout) findViewById(R.id.ll_in_softwareupdateactivity_for_tips);
        tv_in_softwareupdateactivity_for_tips = (TextView) findViewById(R.id.tv_in_softwareupdateactivity_for_tips);

        ll_in_softwareupdateactivity_for_showdownloading = (LinearLayout) findViewById(R.id.ll_in_softwareupdateactivity_for_showdownloading);
        wwv_in_softwareupdateactivity_for_showdownloading = (CircleProgressView) findViewById(R.id.wwv_in_softwareupdateactivity_for_showdownloading);

        ll_in_softwareupdateactivity_for_bottom = (LinearLayout) findViewById(R.id.ll_in_softwareupdateactivity_for_bottom);
        ll_in_softwareupdateactivity_for_cancle = (LinearLayout) findViewById(R.id.ll_in_softwareupdateactivity_for_cancle);
        flb_in_softwareupdateactivity_for_cancle = (FloatingActionButton) findViewById(R.id.flb_in_softwareupdateactivity_for_cancle);
        flb_in_softwareupdateactivity_for_cancle.setOnClickListener(this);
        ll_in_softwareupdateactivity_for_sure = (LinearLayout) findViewById(R.id.ll_in_softwareupdateactivity_for_sure);
        flb_in_softwareupdateactivity_for_sure = (FloatingActionButton) findViewById(R.id.flb_in_softwareupdateactivity_for_sure);
        flb_in_softwareupdateactivity_for_sure.setOnClickListener(this);
    }

    @Override
    protected void OnBindDataWithUi() {
        // TODO Auto-generated method stub
        super.OnBindDataWithUi();
        mPercent = 0.0f;
        wwv_in_softwareupdateactivity_for_showdownloading.setMaxValue(100);
        wwv_in_softwareupdateactivity_for_showdownloading.setValue(0);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v == flb_in_softwareupdateactivity_for_sure) {

        }
    }

    private void check() {
//        wwv_in_softwareupdateactivity_for_showloading.setValueAnimated(mPercent);
//        mPercent +=1f;
        mThread = new Thread(new Runnable() {

            @Override
            public void run() {

                mPercent = 0;
                while (mPercent <= 100) {
                    wwv_in_softwareupdateactivity_for_showdownloading.setValueAnimated(mPercent, 100);
                    mPercent += 1f;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当进度条到100%时，重置初始百分比
                mPercent = 0.0f;
                wwv_in_softwareupdateactivity_for_showdownloading.setValueAnimated(mPercent);
            }
        });
        mThread.start();
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        super.onEventRunEnd(event);
    }

    @Override
    protected void onInitAttribute(ActivityBaseAttribute ba) {
        super.onInitAttribute(ba);
        ba.setHasNavigationBar(false);
    }

    public static void launch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, SoftWareUpdateActivity.class)) {
            Intent intent = new Intent(activity, SoftWareUpdateActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

package com.sintn.hera.mobile.cash.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.R;

/**
 * @com.sintn.hera.shop.widget.dialog
 * @HuiyuantongVenusShopCash-V3.x
 * @SearchProductDialog.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 显示通用提示消息的对话框对话框
 * @2015-2-11下午3:41:49
 */
public class ShowNormalEnterPassowrodWithCallbackDialog extends BaseTouchHiddenSoftInputDialog {

    private String msg;
    private int callBackEventCode;

    public ShowNormalEnterPassowrodWithCallbackDialog(Context context, String msg, int callBackEventCode) {
        super(context, R.style.backgroundTransparentDialog);
        this.context = context;
        this.msg = msg;
        this.callBackEventCode = callBackEventCode;
        this.create();
        this.onIniitUiAndData();
    }

    @SuppressWarnings("deprecation")
    public void create() {
        // TODO Auto-generated method stub
        this.setContentView(R.layout.zone_dialog_show_normal_choice_message);
        // 设置点击对话框周边消失
        this.setCanceledOnTouchOutside(false);
        Window dialogWindow = this.getWindow();
        // 添加动画
        dialogWindow.setWindowAnimations(R.style.mystyle_scale);
        WindowManager m = dialogWindow.getWindowManager();
        // 获取屏幕宽、高用
        Display d = m.getDefaultDisplay();
        // 获取对话框当前的参数值
        WindowManager.LayoutParams parm = dialogWindow.getAttributes();
        parm.height = (int) (d.getHeight() * 0.5);
        parm.width = (int) (d.getWidth() * 1.0);
        dialogWindow.setGravity(Gravity.TOP);
        dialogWindow.setAttributes(parm);
    }

    @SuppressLint("SetTextI18n")
    protected void onIniitUiAndData() {
        // TODO Auto-generated method stub
        // 初始化UI
        ((TextView) findViewById(R.id.zone_dialog_show_normal_message_tv_message)).setText(this.msg);
        // set the submit button
        findViewById(R.id.zone_dialog_show_normal_message_tv_sure).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
                // 发送全局回调参数
                AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(callBackEventCode), 0);
            }
        });
        findViewById(R.id.zone_dialog_show_normal_message_tv_cancle).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void dismiss() {
        // TODO Auto-generated method stub
        context = null;
        super.dismiss();
    }

}

package com.sintn.hera.mobile.cash.widget.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.entity.conast.OnlinePaymentType;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.QRImageUtils;


/**
 * @com.sintn.hera.shop.widget.dialog
 * @HuiyuantongVenusShopCash-V3.x
 * @SearchProductDialog.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 显示通用提示消息的对话框对话框
 * @2015-2-11下午3:41:49
 */
public class QrcodeDialog extends BaseTouchHiddenSoftInputDialog {
    private LinearLayout ll_in_qecodedialog_for_root= null;
    private ImageView iv_in_qecodedialog_for_qrcodeimage = null;
    private TextView iv_in_qecodedialog_for_tip = null;
    private TextView iv_in_qecodedialog_for_value = null;
    private FloatingActionButton fbtn_in_qecodedialog_for_cancle= null;
    @SuppressWarnings("unused")
    private int eventCode = -1;
    private int paymentType = 0;
    private String url = null;
    private Double value = null;

    public QrcodeDialog(Context context, int paymentType, int eventCode, Double value, String url) {
        super(context, R.style.backgroundTransparentDialog);
        this.context = context;
        this.paymentType = paymentType;
        this.eventCode = eventCode;
        this.value = value;
        this.url = url;
        this.create();
        this.onIniitUiAndData();
        // 设置监听
        setOnKeyListener(keyListener);
    }

    @SuppressWarnings("deprecation")
    public void create() {
        // TODO Auto-generated method stub
        this.setContentView(R.layout.zone_dialog_for_qrcode);
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
        parm.height = (int) (d.getHeight() * 1.0);
        parm.width = (int) (d.getWidth() * 1.0);
        dialogWindow.setGravity(Gravity.CENTER);
        dialogWindow.setAttributes(parm);
    }

    @SuppressLint("SetTextI18n")
    protected void onIniitUiAndData() {
        // TODO Auto-generated method stub
        ll_in_qecodedialog_for_root = (LinearLayout) findViewById(R.id.ll_in_qecodedialog_for_root);
        iv_in_qecodedialog_for_value = (TextView) findViewById(R.id.iv_in_qecodedialog_for_value);
        iv_in_qecodedialog_for_value.setText(context.getResources().getString(R.string.lable_rmb) + CommonUtils.formatDouble2String(value));
        iv_in_qecodedialog_for_tip = (TextView) findViewById(R.id.iv_in_qecodedialog_for_tip);
        if (paymentType == OnlinePaymentType.WEIXIN_QRCODE_USER_SCAN) {
            iv_in_qecodedialog_for_tip.setText(context.getString(R.string.lable_qrcode_pay_of_weichat));
        } else if (paymentType == OnlinePaymentType.ALIPAY_QRCODE_USER_SCAN) {
            iv_in_qecodedialog_for_tip.setText(context.getString(R.string.lable_qrcode_pay_of_alipay));
        }
        iv_in_qecodedialog_for_qrcodeimage = (ImageView) findViewById(R.id.iv_in_qecodedialog_for_qrcodeimage);
        if (null != url) {
            Bitmap bm =null;
//                    = QRImageUtils.createQRImage(url);
            if (paymentType == OnlinePaymentType.WEIXIN_QRCODE_USER_SCAN) {
                bm=QRImageUtils.createCode(url,context,R.drawable.weixin_logo);
            } else if (paymentType == OnlinePaymentType.ALIPAY_QRCODE_USER_SCAN) {
                bm=QRImageUtils.createCode(url,context,R.drawable.alipay_logo);
            }
            if (bm != null) {
                iv_in_qecodedialog_for_qrcodeimage.setImageBitmap(bm);
            }
        }
        fbtn_in_qecodedialog_for_cancle=(FloatingActionButton) this.findViewById(R.id.fbtn_in_qecodedialog_for_cancle);
        fbtn_in_qecodedialog_for_cancle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.DIALOG_CALLBACK_O_CANCLE_QRCODE_PAY), 0);
                dismiss();
            }
        });

        {
            if (paymentType == OnlinePaymentType.WEIXIN_QRCODE_USER_SCAN) {
                ll_in_qecodedialog_for_root.setBackgroundColor(context.getResources().getColor(R.color.sintn_weixinbg_color));
                fbtn_in_qecodedialog_for_cancle.setBackgroundTintList(context.getResources().getColorStateList(R.color.selector_floatbutton_weixinbg));
            } else if (paymentType == OnlinePaymentType.ALIPAY_QRCODE_USER_SCAN) {
                ll_in_qecodedialog_for_root.setBackgroundColor(context.getResources().getColor(R.color.sintn_alipaybg_color));
                fbtn_in_qecodedialog_for_cancle.setBackgroundTintList(context.getResources().getColorStateList(R.color.selector_floatbutton_alipaybg));
            }

        }
    }

    @Override
    public void dismiss() {
        // TODO Auto-generated method stub
        context = null;
        super.dismiss();
    }

    /**
     * 监听事件
     */
    OnKeyListener keyListener = new OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            // 判断是否按下了home、返回、和屏幕
            if (keyCode == KeyEvent.KEYCODE_HOME || keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_SEARCH) {
                AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.DIALOG_CALLBACK_O_CANCLE_QRCODE_PAY), 0);
                dismiss();
                return false;
            }
            return false;
        }
    };

}

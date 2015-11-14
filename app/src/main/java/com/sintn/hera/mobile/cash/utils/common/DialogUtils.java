package com.sintn.hera.mobile.cash.utils.common;

import android.content.Context;

import com.sintn.hera.mobile.cash.widget.dialog.LoadingDialog;
import com.sintn.hera.mobile.cash.widget.dialog.NormalDateChoiceWithCallbackDialog;
import com.sintn.hera.mobile.cash.widget.dialog.QrcodeDialog;
import com.sintn.hera.mobile.cash.widget.dialog.ShowNormalChioceMessagWithCallbackDialog;

/**
 * @Desc: 对话框工具
 * @com.sintn.hera.mobile.cash.utils.common
 * @HuiyuantongVenusMobileCash-V3.x
 * @DialogUtils.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:49:43
 */
public class DialogUtils {
    private static LoadingDialog loadDialog = null;
    private static int eventCode = -1001;

    public static void dissMissLoading(int eventCoder) {
        try {
            if (loadDialog != null && eventCoder == eventCode) {
                // 取消进度对话框
                loadDialog.dismiss();
                loadDialog = null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            loadDialog = null;
        }

    }

    public static void dissMissLoading() {
        try {
            if (loadDialog != null) {
                // 取消进度对话框
                loadDialog.dismiss();
                loadDialog = null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            loadDialog = null;
        }
    }

    public static void showLoading(Context context, int eventCoder) {
        if (context == null) {
            return;
        }
        try {
            if (loadDialog != null) {
                // 取消进度对话框
                loadDialog.dismiss();
                loadDialog = null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            loadDialog = null;
        } finally {
            eventCode = eventCoder;
            loadDialog = new LoadingDialog(context);
            loadDialog.show();
        }

    }

    // //////////////////////////////normal/////////////////////////////////////
    public static void ShowNormalDateChoiceWithCallbackDialog(Context context, boolean needShowTimePocker) {
        NormalDateChoiceWithCallbackDialog normalDateChoiceWithCallbackDialog = new NormalDateChoiceWithCallbackDialog(context, needShowTimePocker);
        normalDateChoiceWithCallbackDialog.show();
    }

    public static void ShowNormalDateChoiceWithCallbackDialog(Context context, int eventCode, boolean needShowTimePocker) {
        NormalDateChoiceWithCallbackDialog normalDateChoiceWithCallbackDialog = new NormalDateChoiceWithCallbackDialog(context, eventCode, needShowTimePocker);
        normalDateChoiceWithCallbackDialog.show();
    }

    public static void ShowNormalChioceMessagWithCallbackDialog(Context context, int res, int callBackEventCode) {
        ShowNormalChioceMessagWithCallbackDialog showNormalChioceMessagWithCallbackDialog = new ShowNormalChioceMessagWithCallbackDialog(context, context.getString(res),
                callBackEventCode);
        showNormalChioceMessagWithCallbackDialog.show();
    }

    public static void ShowNormalChioceMessagWithCallbackDialog(Context context, String res, int callBackEventCode) {
        ShowNormalChioceMessagWithCallbackDialog showNormalChioceMessagWithCallbackDialog = new ShowNormalChioceMessagWithCallbackDialog(context, res,
                callBackEventCode);
        showNormalChioceMessagWithCallbackDialog.show();
    }

    public static void ShowQrcodeDialog(Context context, int paymentType, int eventCode, Double value, String url) {
        QrcodeDialog qrcodeDialog = new QrcodeDialog(context, paymentType, eventCode, value, url);
        qrcodeDialog.show();
    }
}

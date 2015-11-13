package com.sintn.hera.mobile.cash.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.widget.numberbar.NumberProgressBar;

public class DownLoadingDialog extends Dialog {
    private NumberProgressBar numpb_in_dialog_for_progress;

    public DownLoadingDialog(Context context) {
        super(context, R.style.backgroundTransparentDialog);
        // TODO Auto-generated constructor stub
        this.setCanceledOnTouchOutside(false);// 设置点击边缘不关闭
        // 设置监听
        setOnKeyListener(keyListener);
        // 初始化Dialog参数
        initDialog();
        //初始化DialogUI
        initUi();
    }

    @SuppressWarnings("deprecation")
    private void initDialog() {
        // 设置布局文件
        setContentView(R.layout.zone_dialog_downloading);
        Window dialogWindow = getWindow();
        // 添加动画
        dialogWindow.setWindowAnimations(R.style.mystyle_scale);
        WindowManager m = dialogWindow.getWindowManager();
        // 获取屏幕宽、高用
        Display d = m.getDefaultDisplay();
        // 获取对话框当前的参数值
        WindowManager.LayoutParams parm = dialogWindow.getAttributes();
        parm.height = (int) (d.getHeight() * 0.3);
        parm.width = (int) (d.getWidth() * 1.0);
        dialogWindow.setGravity(Gravity.TOP);
        dialogWindow.setAttributes(parm);
    }

    private void initUi() {
        numpb_in_dialog_for_progress = (NumberProgressBar) findViewById(R.id.numpb_in_dialog_for_progress);
        numpb_in_dialog_for_progress.setProgress(0);
    }

    public void updateProgress(int progress) {
        numpb_in_dialog_for_progress.setProgress(progress);
    }

    @Override
    public void dismiss() {
        // TODO Auto-generated method stub
        super.dismiss();
    }

    /**
     * 监听事件
     */
    OnKeyListener keyListener = new OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            // 判断是否按下了home、返回、和屏幕
            if (keyCode == KeyEvent.KEYCODE_HOME || keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_SEARCH) {
                return true;
            }
            return false;
        }
    };
}
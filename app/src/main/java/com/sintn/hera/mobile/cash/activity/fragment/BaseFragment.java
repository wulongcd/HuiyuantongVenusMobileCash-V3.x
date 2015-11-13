package com.sintn.hera.mobile.cash.activity.fragment;

import java.util.Date;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.HttpEvent;
import com.sintn.hera.mobile.cash.listener.OnFragementActivityResult;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.utils.common.ToastManager;
import com.sintn.hera.mobile.cash.utils.core.EventManager.OnEventListener;
import com.sintn.hera.mobile.cash.R;

/**
 * @Desc: 碎片基类
 * @com.sintn.hera.mobile.cash.activity.fragment
 * @HuiyuantongVenusMobileCash-V3.x
 * @BaseFragment.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:53:21
 */
@SuppressLint("ClickableViewAccessibility")
public class BaseFragment extends Fragment implements OnFragementActivityResult, OnCheckedChangeListener, OnTouchListener, OnEventListener, OnClickListener, OnItemClickListener {
    /**
     * 每个碎片上所有事件编码集合
     */
    private SparseArray<OnEventListener> codeToListenerMap;
    /**
     * 全局事件编码
     */
    protected int eventCode = -1;
    /**
     *
     */
    private boolean loadFinish = false;
    /**
     *
     */
    protected View rootView;
    /**
     *
     */
    protected int clickViewId = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isAdded()) {
            if (!loadFinish) {
                loadFinish = true;
                new AsyncTask<Void, Integer, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        // TODO Auto-generated method stub
                        OnInitUiAndData();
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        // TODO Auto-generated method stub
                        super.onPostExecute(result);
                        OnBindDataWithUi();
                    }
                }.execute();
            }
        }
    }

    /**
     * 加载UI元素和数据
     */
    protected void OnInitUiAndData() {

    }

    /**
     * 绑定数据到UI元素上
     */
    protected void OnBindDataWithUi() {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event, int eventCode) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onListChildViewClicked(View view, Object object) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View view, int clickedViewId) {
        // TODO Auto-generated method stub

    }

    /**
     * 添加回调事件
     *
     * @param nEventCode
     */
    protected void addCallbackEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            codeToListenerMap = new SparseArray<OnEventListener>();
        }
        codeToListenerMap.put(nEventCode, this);
        AndroidEventManager.getInstance().addEventListener(nEventCode, this, false);
    }

    /**
     * 移除事件
     *
     * @param nEventCode
     */
    protected void removeCallbackEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            return;
        }
        codeToListenerMap.remove(nEventCode);
        AndroidEventManager.getInstance().removeEventListener(nEventCode, this);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        eventCode = event.getEventCode();
        if (event instanceof HttpEvent) {
            if ((!((HttpEvent) event).isNetSuccess())
                    || (((HttpEvent) event).isServerIsServerNotArrabile())
                    || (((HttpEvent) event).isUnAuthorized())
                    || (((HttpEvent) event).isServerIsNotArrabileNOTKonwnREson())
                    ) {
                DialogUtils.dissMissLoading(eventCode);
                return;
            } else if (((HttpEvent) event).isMethodNotAllowed()) {
                DialogUtils.dissMissLoading(eventCode);
                if (((HttpEvent) event).getErrorObject() != null) {
                    if (((HttpEvent) event).getErrorObject().getCode() == 4)// 未登录退出重登
                    {
                        showMessageAndJumpToLogin();
                        return;
                    } else if (((HttpEvent) event).getErrorObject().getCode() == 45)// 被踢掉退出重登
                    {
                        showMessageAndJumpToLogin();
                        return;
                    }
                }
                return;
            } else if (((HttpEvent) event).getErrorObject() != null) {
                if (((HttpEvent) event).getErrorObject().getCode() == 4)// 未登录退出重登
                {
                    showMessageAndJumpToLogin();
                    return;
                } else if (((HttpEvent) event).getErrorObject().getCode() == 45)// 被踢掉退出重登
                {
                    showMessageAndJumpToLogin();
                    return;
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (CommonUtils.isButtonFastClickAtALittleTime()) {
            return;
        } else {
            clickViewId = v.getId();
        }
    }

    protected void showMessageAndJumpToLogin() {
        // TODO Auto-generated method stub
        AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.CALLBACK_IN_FRAGMENT_TASK_ACTIVITY_THAT_NET_ERROR), 0);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (codeToListenerMap != null) {
            final int nCount = codeToListenerMap.size();
            for (int nIndex = 0; nIndex < nCount; ++nIndex) {
                removeCallbackEventListener(codeToListenerMap.keyAt(nIndex));
            }
            codeToListenerMap.clear();
        }
        // 强制清理此对象资源
        System.gc();
    }

    //返回当前日期
    public Date getDate() {
        return new Date(System.currentTimeMillis());
    }

}

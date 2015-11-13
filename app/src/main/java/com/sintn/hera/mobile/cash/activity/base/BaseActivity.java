package com.sintn.hera.mobile.cash.activity.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.login.LoginActivity;
import com.sintn.hera.mobile.cash.activity.login.RegisterActivity;
import com.sintn.hera.mobile.cash.activity.main.MainActivity;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.entity.up.LoginForCashierAppUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.HttpEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.MoblieCashLogOutEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.MoblieCashLoginUpEvent;
import com.sintn.hera.mobile.cash.listener.OnExpandableListViewItemLongClickListener;
import com.sintn.hera.mobile.cash.listener.OnGridViewItemClickListener;
import com.sintn.hera.mobile.cash.listener.OnListViewChildViewClickListener;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DensityManagerUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.utils.common.ToastManager;
import com.sintn.hera.mobile.cash.utils.core.EventManager.OnEventListener;
import com.sintn.hera.mobile.cash.R;

/**
 * @Desc: Activity基类
 * @com.sintn.hera.mobile.cash.activity.base
 * @HuiyuantongVenusShopCash-V3.x
 * @BaseActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-2-6下午3:21:33
 */
@SuppressLint(
        {"InflateParams", "SdCardPath", "InlinedApi"})
public class BaseActivity extends AppCompatActivity implements OnClickListener, OnEventListener, OnListViewChildViewClickListener, OnItemClickListener, OnItemLongClickListener,
        OnGridViewItemClickListener, OnPageChangeListener, OnGroupClickListener, OnExpandableListViewItemLongClickListener {

    public final static String EXTRA_CUSTOMERCARDRELATEDINFODOWN = "CustomerCardRelatedInfoDown";
    protected int requestCodeOfCustomerCardRelatedInfoDown = 1234;
    protected int requestCodeForOrderScuessToupdateCustomer = 1233;
    protected int requestCodeForEditCustomer = 1236;
    protected LoginForCashierAppUp loginForCashierAppUp;

    //提示管理器
    public ToastManager toastManager;
    //上下文
    protected Context mContext;
    //基础属性抽象
    protected ActivityBaseAttribute baseAttribute;
    //每个界面上所有事件编码集合
    private SparseArray<OnEventListener> codeToListenerMap;
    //全局点击VIEW缓存变量
    protected View clickView;
    //全局圆角头像参数 DisplayImageOptions
    private DisplayImageOptions avatarDisplayImageOptions;
    //全局默认参数 DisplayImageOptions
    private DisplayImageOptions defaultDisplayImageOptions;
    //全局点击VIEWID
    protected int clickedViewId;
    //事件编码
    protected int eventCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        BaseApplication.addActivity(this);
        baseAttribute = new ActivityBaseAttribute(this);
        onInitAttribute(baseAttribute);
        baseAttribute.setContentView();
        toastManager = ToastManager.getInstance(getApplicationContext());
        onInitBaseActivity();
        addCallbackEventListener(EventCode.CALLBACK_APPLICATION_NOTIFICATION_TO_ACTIVITY);
        addCallbackEventListener(EventCode.CALLBACK_SAME_ACCOUNT_ANOTHER_PLACE_LOGIN);
        addCallbackEventListener(EventCode.CALLBACK_IN_FRAGMENT_TASK_ACTIVITY_THAT_NET_ERROR);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        removeCallbackEventListener(EventCode.CALLBACK_APPLICATION_NOTIFICATION_TO_ACTIVITY);
        removeCallbackEventListener(EventCode.CALLBACK_IN_FRAGMENT_TASK_ACTIVITY_THAT_NET_ERROR);
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        addCallbackEventListener(EventCode.CALLBACK_APPLICATION_NOTIFICATION_TO_ACTIVITY);
        addCallbackEventListener(EventCode.CALLBACK_IN_FRAGMENT_TASK_ACTIVITY_THAT_NET_ERROR);
    }

    /**
     * 异步初始化UI和数据
     */
    protected void onInitBaseActivity() {
        // TODO Auto-generated method stub
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

    /**
     * 初始化属性
     *
     * @param ba
     */
    protected void onInitAttribute(ActivityBaseAttribute ba) {
        ba.setHasContentView(true);
        ba.setHasNavigationBar(true);
    }

    /**
     * 获取手机状态栏高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * 获取ActionBar的高度
     *
     * @return
     */
    public int getActionBarHeight() {
        TypedValue tv = new TypedValue();
        int actionBarHeight = 0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))// 如果资源是存在的、有效的
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }
        return actionBarHeight;
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
     * 添加一次性事件
     *
     * @param nEventCode
     */
    protected void addOncesEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            codeToListenerMap = new SparseArray<OnEventListener>();
        }
        codeToListenerMap.put(nEventCode, this);
        AndroidEventManager.getInstance().addEventListener(nEventCode, this, true);
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

    /**
     * 返回360度圆角图片参数的DisplayImageOptions
     *
     * @return DisplayImageOptions
     */
    @SuppressWarnings("deprecation")
    public DisplayImageOptions getAvatarDisplayImageOptions() {
        if (avatarDisplayImageOptions == null) {
            avatarDisplayImageOptions = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.user_image_default) // 设置图片在下载期间显示的图片
                    .showImageForEmptyUri(R.drawable.user_image_default)// 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(R.drawable.user_image_default) // 设置图片加载/解码过程中错误时候显示的图片
                    .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                    .cacheOnDisc(true)// 设置下载的图片是否缓存在SD卡中
                    .considerExifParams(true) // 是否考虑JPEG图像EXIF参数（旋转，翻转）
                    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
                    .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
                            // .decodingOptions(android.graphics.BitmapFactory.OptionsdecodingOptions)//
                            // 设置图片的解码配置
                            // .delayBeforeLoading(int delayInMillis)//int
                            // delayInMillis为你设置的下载前的延迟时间
                            // .preProcessor(BitmapProcessor
                            // preProcessor)//设置图片加入缓存前，对bitmap进行设置
                    .resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
                            // .displayer(new RoundedBitmapDisplayer(0))// 是否设置为圆角，弧度为多少
                            // .displayer(new FadeInBitmapDisplayer(0))//
                            // 是否图片加载好后渐入的动画时间
                    .build();// 构建完成
        }
        return avatarDisplayImageOptions;
    }

    /**
     * 返回默认的图片参数的DisplayImageOptions
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public DisplayImageOptions getDefaultDisplayImageOptions() {
        if (defaultDisplayImageOptions == null) {
            defaultDisplayImageOptions = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.ic_launcher) // 设置图片在下载期间显示的图片
                    .showImageForEmptyUri(R.drawable.ic_launcher)// 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(R.drawable.ic_launcher) // 设置图片加载/解码过程中错误时候显示的图片
                    .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                    .cacheOnDisc(true)// 设置下载的图片是否缓存在SD卡中
                    .considerExifParams(true) // 是否考虑JPEG图像EXIF参数（旋转，翻转）
                    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
                            // .bitmapConfig(Bitmap.Config.RGB_565)//设置图片的解码类型//
                            // .decodingOptions(android.graphics.BitmapFactory.Options
                            // decodingOptions)//设置图片的解码配置
                            // .delayBeforeLoading(int delayInMillis)//int
                            // delayInMillis为你设置的下载前的延迟时间
                            // .preProcessor(BitmapProcessor
                            // preProcessor)//设置图片加入缓存前，对bitmap进行设置
                    .resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
                    .displayer(new RoundedBitmapDisplayer(0))// 是否设置为圆角，弧度为多少
                    .displayer(new FadeInBitmapDisplayer(100))// 是否图片加载好后渐入的动画时间
                    .build();// 构建完成
        }
        return defaultDisplayImageOptions;
    }

    /**
     * 返回默认的图片参数的DisplayImageOptions
     *
     * @return
     */
    @SuppressWarnings("deprecation")
    public DisplayImageOptions getDefaultDisplayImageOptionsForBankIcon() {
        if (defaultDisplayImageOptions == null) {
            defaultDisplayImageOptions = new DisplayImageOptions.Builder().showImageOnLoading(R.drawable.bank_default) // 设置图片在下载期间显示的图片
                    .showImageForEmptyUri(R.drawable.bank_default)// 设置图片Uri为空或是错误的时候显示的图片
                    .showImageOnFail(R.drawable.bank_default) // 设置图片加载/解码过程中错误时候显示的图片
                    .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                    .cacheOnDisc(true)// 设置下载的图片是否缓存在SD卡中
                    .considerExifParams(true) // 是否考虑JPEG图像EXIF参数（旋转，翻转）
                    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
                    .resetViewBeforeLoading(true)// 设置图片在下载前是否重置，复位
                    .displayer(new RoundedBitmapDisplayer(0))// 是否设置为圆角，弧度为多少
                    .displayer(new FadeInBitmapDisplayer(0))// 是否图片加载好后渐入的动画时间
                    .build();// 构建完成
        }
        return defaultDisplayImageOptions;
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        if (isFinishing()) {
            return;
        }
        eventCode = event.getEventCode();

        if (event instanceof HttpEvent) {
            if ((!((HttpEvent) event).isNetSuccess())
                    || (((HttpEvent) event).isServerIsServerNotArrabile())
                    || (((HttpEvent) event).isUnAuthorized())
                    || (((HttpEvent) event).isServerIsNotArrabileNOTKonwnREson())
                    ) {
                DialogUtils.dissMissLoading(eventCode);
                toastManager.show(R.string.http502badgetawayShowing);
                return;
            }
        }
        if (EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN == event.getEventCode()) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN);
            final MoblieCashLoginUpEvent loginUpEvent = (MoblieCashLoginUpEvent) event;
            if (loginUpEvent.isNetSuccess()) {
                if (loginUpEvent.isOk()) {
                    if (loginUpEvent.getResult() > 0) {
                        BaseApplication.getLocalManager().setRoleType(loginUpEvent.getResult());
                        BaseApplication.getLocalManager().saveLoginForCashierAppUp(loginForCashierAppUp.getUsername(), loginForCashierAppUp.getPassword());
                        BaseApplication.setisLogined(true);
                        if (this.getClass().getName().equals(LoginActivity.class.getName()) || this.getClass().getName().equals(RegisterActivity.class.getName())) {
                            MainActivity.launch(this);
                        }
                    }
                } else {
                    if (loginUpEvent.getErrorObject() == null) {
                        toastManager.show(loginUpEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(loginUpEvent.getErrorObject()));
                    }
                }
            }
            return;
        } else if (EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT == event.getEventCode()) {
            DialogUtils.dissMissLoading(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT);
            final MoblieCashLogOutEvent moblieCashLogOutEvent = (MoblieCashLogOutEvent) event;
            if (moblieCashLogOutEvent.isNetSuccess()) {
                if (moblieCashLogOutEvent.isOk()) {
                    if (moblieCashLogOutEvent.getResult() != null && moblieCashLogOutEvent.getResult().equals("ok")) {
                        BaseApplication.logout();
                        if (!this.getClass().getName().equals(LoginActivity.class.getName())) {
                            LoginActivity.launch(this);
                        }
                    }
                } else {
                    BaseApplication.logout();
                    if (!this.getClass().getName().equals(LoginActivity.class.getName())) {
                        LoginActivity.launch(this);
                    }
                }
            }
            return;
        } else if (eventCode == EventCode.CALLBACK_APPLICATION_NOTIFICATION_TO_ACTIVITY) {
            DialogUtils.dissMissLoading();
            MobileCashBaseCallbackEvent applicationCallbackEvent = (MobileCashBaseCallbackEvent) event;
            Object object = applicationCallbackEvent.getReturnParam();
            if (object instanceof HttpEvent) {
                HttpEvent event2 = (HttpEvent) object;
                if (!((HttpEvent) event2).isNetSuccess()) {
                    toastManager.show("服务器" + URLUtils.HOST + "\n" + getString(R.string.no_net));
                    return;
                } else if (((HttpEvent) event2).isServerIsServerNotArrabile()) {
                    toastManager.show(R.string.http502badgetawayShowing);
                    return;
                } else if (((HttpEvent) event2).isUnAuthorized()) {
                    toastManager.show(R.string.http401unAuthorizedShowing);
                    return;
                } else if (((HttpEvent) event2).isServerIsNotArrabileNOTKonwnREson()) {
                    toastManager.show(R.string.httpsNotArrabileNOTKonwnREsonShowing);
                    return;
                } else if (((HttpEvent) event2).isMethodNotAllowed()) {
                    if (((HttpEvent) event2).getErrorObject() != null) {
                        if (((HttpEvent) event2).getErrorObject().getCode() == 4)// 未登录退出重登
                        {
                            showMessageAndJumpToLogin("你的账号还未登陆，请重登！");
                        }
                    } else if (((HttpEvent) event).getErrorObject().getCode() == 45)// 被踢掉退出重登
                    {
                        showMessageAndJumpToLogin("你的账号在其他设备登陆，你已经被迫下线！");
                        return;
                    }
                } else {
                    toastManager.show(applicationCallbackEvent.getReturnParam().toString());
                }
            } else {
                toastManager.show(applicationCallbackEvent.getReturnParam().toString());
            }
            return;
        } else if (eventCode == EventCode.CALLBACK_SAME_ACCOUNT_ANOTHER_PLACE_LOGIN) {
            showMessageAndJumpToLogin("你的账号在其他设备登陆，你已经被迫下线！");
            return;
        } else if (eventCode == EventCode.CALLBACK_IN_FRAGMENT_TASK_ACTIVITY_THAT_NET_ERROR) {
            showMessageAndJumpToLogin("网络异常，你已经被迫下线！");
            return;
        }
    }

    /**
     * @param msg
     */
    protected void showMessageAndJumpToLogin(String msg) {
        // TODO Auto-generated method stub
        if (msg != null) {
//            toastManager.show(msg);
            login(BaseApplication.getLocalManager().getLoginForCashierAppUp().getUsername(), BaseApplication.getLocalManager().getLoginForCashierAppUp().getPassword());
        }

    }

    /**
     * @param mEtInput
     */
    protected void hiddleSoftInputForEdittext(EditText mEtInput) {
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            mEtInput.setInputType(InputType.TYPE_NULL);
        } else {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(mEtInput, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (isFinishing()) {
            return;
        }
        if (CommonUtils.isButtonFastClickAtALittleTime()) {
            return;
        }
        clickedViewId = v.getId();
        clickView = v;
    }

    // ////////////////点击EditText文本框之外任何地方隐藏键盘/////////////////////////
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop =
                    {0, 0};
            // 获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    // ///////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onExpandableListViewItemLongClick(int viewId, Object object) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onGridViewItemClicked(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onListChildViewClicked(View v, Object object) {
        // TODO Auto-generated method stub

    }

    protected void onBackPressedAsHomePressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }


    /**
     * 判断当前设备物理尺寸是否大于7.9英寸
     *
     * @return
     */
    protected boolean isThisMashionUpTo7Point9Inch() {
        return DensityManagerUtils.getScreenPhysicSizeWithInch(this) >= 7.9;
    }

    /**
     * @param username
     * @param pwd
     */
    public void login(String username, String pwd) {
        loginForCashierAppUp = new LoginForCashierAppUp(username, pwd);
        DialogUtils.showLoading(mContext, EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN);
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN, 0, URLUtils.URL_SHOPMANAGERACCOUNT_LOGIN_IN, loginForCashierAppUp);
    }

    /**
     *
     */
    public void logout() {
        DialogUtils.showLoading(mContext, EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT);
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT, 0, URLUtils.URL_SHOPMANAGERACCOUNT_LOGIN_OUT);
    }

    /**
     * 界面销毁回调函数
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.removeActivity(this);
        if (codeToListenerMap != null) {
            final int nCount = codeToListenerMap.size();
            for (int nIndex = 0; nIndex < nCount; ++nIndex) {
                removeCallbackEventListener(codeToListenerMap.keyAt(nIndex));
            }
            codeToListenerMap.clear();
        }
        requestCodeOfCustomerCardRelatedInfoDown = 0;
        requestCodeForOrderScuessToupdateCustomer = 0;
        requestCodeForEditCustomer = 0;
        toastManager = null;// 提示管理器
        mContext = null;// 上下文
        baseAttribute = null;// 基础属性抽象
        clickView = null;// 点击VIEW
        avatarDisplayImageOptions = null;// 圆角头像参数
        defaultDisplayImageOptions = null;// 默认参数
        clickedViewId = 0;// 点击VIEWID
        eventCode = 0;// 事件编码
        // 设置空的布局快速释放内存
        setContentView(R.layout.a_a_null_view);
        // 强制清理此Activity对象资源
        System.gc();
    }

    //获取当前日期
    @SuppressLint("SimpleDateFormat")
    public String getNowTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTimeInMillis(System.currentTimeMillis());
        String nowTime = sdf.format(calendar.getTime());
        return nowTime;
    }

}

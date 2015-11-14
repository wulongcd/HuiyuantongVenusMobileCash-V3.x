package com.sintn.hera.mobile.cash;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.igexin.sdk.PushManager;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.sintn.hera.mobile.cash.entity.conast.AppType;
import com.sintn.hera.mobile.cash.entity.conast.OSType;
import com.sintn.hera.mobile.cash.entity.down.AppVersion;
import com.sintn.hera.mobile.cash.entity.up.DeviceInfoUp;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.AddBindingBankEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.AddShopCashierEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.AddShopEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.DeleteBindingBankEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.DeleteShopCashierEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryBankListEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryBanlanceEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryBindingBankListEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryEnterpriseInfoEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryFirstCategoryEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryFirstRegionEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QuerySecondCategoryEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryShopCashierListEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QueryShopListEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.QuerySubRegionEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.RegisterEnterpriseInfoEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.SetWithdrawPasswordEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.UpdateEnterpriseInfoEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.UpdateShopCashierEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.UpdateShopInfoEvent;
import com.sintn.hera.mobile.cash.event.httpevent.cash.WithdrawEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.CreateQrCodeOrderEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.GetVerificationCodeEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.MoblieCashLogOutEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.MoblieCashLoginUpEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QueryQrcodeOrderEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QueryQrcodeOrderTotalEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QueryStatusForQrcodeOrderEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QuerylatestAppVersionEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.RegisterAccountEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.SetPasswordUpEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.VerifyAccountUpEvent;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.manager.AppDatabaseManager;
import com.sintn.hera.mobile.cash.manager.LocalDataManager;
import com.sintn.hera.mobile.cash.manager.SharedPreferenceManager;
import com.sintn.hera.mobile.cash.manager.StatusBarManager;
import com.sintn.hera.mobile.cash.manager.UserDatebaseManager;
import com.sintn.hera.mobile.cash.manager.VersionManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.CrashHandler;
import com.sintn.hera.mobile.cash.utils.common.DeviceInfoUtil;
import com.sintn.hera.mobile.cash.utils.core.DataClearManager;
import com.sintn.hera.mobile.cash.utils.core.EventManager.OnEventListener;
import com.sintn.hera.mobile.cash.utils.core.LoggerSystemOutHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Desc: 全局APPLICATION类
 * @com.sintn.hera.mobile.cash
 * @HuiyuantongVenusMobileCash-V3.x
 * @BaseApplication.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:47:23
 */
public class BaseApplication extends Application implements OnEventListener, AMapLocationListener {
    /**
     * 测试么？
     */
    private static boolean isNowTest = true;
    /**
     * application单例对象
     */
    private static BaseApplication instance;
    /**
     * 高德定位工具实例对象
     */
    private static LocationManagerProxy locationManagerProxy;
    /**
     * 高德定位辅助器
     */
    private static AMapLocation aMapLocation;
    /**
     * 全局处理器
     */
    private static Handler handler;
    /**
     * LOG 记录器
     */
    private static Logger sLogger;
    /**
     * 消息推送ID
     */
    private static String pushId;
    /**
     * 全局Activity管理
     */
    public static List<Activity> activities = null;

    // private static boolean onlyOneEnterprise;

    public static boolean isNowTest() {
        return isNowTest;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        activities = new ArrayList<Activity>();
        handler = new Handler();
        instance = this;
        // 全局异常抓取器
        CrashHandler handler = CrashHandler.getInstance();
        handler.init(getApplicationContext());
        pushId = getLocalManager().getPushId();
        ApplicationScriptInit();
        ApplicationEventManagerEnevtsInit();
    }

    /**
     * 初始化各类管理工具
     */
    public void ApplicationScriptInit() {
        // 启动通知管理工具
        StatusBarManager.getInstance().onStart();
        // 初始化imageLoader工具
        initImageLoader(getApplicationContext());
        // SDK初始化，第三方程序启动时，都要进行SDK初始化工作
        PushManager.getInstance().initialize(getApplicationContext());
    }

    /**
     * 初始化事件管理器并注册全局所有事件
     */
    public void ApplicationEventManagerEnevtsInit() {
        AndroidEventManager eventManager = AndroidEventManager.getInstance();
        //初始化验证账号事件
        eventManager.addEvent(new VerifyAccountUpEvent(EventCode.HTTP_POST_VERIFY_ACCOUNT_EVENT));
        //初始化登陆系统事件
        eventManager.addEvent(new MoblieCashLoginUpEvent(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN));
        //初始化登陆系统事件
        eventManager.addEvent(new QuerylatestAppVersionEvent(EventCode.HTTP_GET_APPVERSION_QUERYLATEST));
        //初始化登陆系统事件
        eventManager.addEvent(new MoblieCashLogOutEvent(EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT));
        // 初始化设置密码界面
        eventManager.addEvent(new SetPasswordUpEvent(EventCode.HTTP_POST_SET_PASSWORD_EVENT));
        // 初始化用户注册界面（服务器端保存）
        eventManager.addEvent(new RegisterAccountEvent(EventCode.HTTP_GET_REGIST_ACCOUNT_EVENT));
        // 初始化用户注册界面（服务器端保存）
        eventManager.addEvent(new CreateQrCodeOrderEvent(EventCode.HTTP_POST_ORDER_CREATE));
        eventManager.addEvent(new QueryStatusForQrcodeOrderEvent(EventCode.HTTP_GET_ORDER_QUERY_STATUS));
        eventManager.addEvent(new QueryQrcodeOrderEvent(EventCode.HTTP_POST_ORDER_QUERY));
        eventManager.addEvent(new QueryQrcodeOrderTotalEvent(EventCode.HTTP_POST_ORDER_QUERYTOTALMONEY));
        //初始化获取验证码事件
        eventManager.addEvent(new GetVerificationCodeEvent(EventCode.HTTP_POST_GET_VERIFICATION_CODE));
        //初始化获取一级行业事件
        eventManager.addEvent(new QueryFirstCategoryEvent(EventCode.HTTP_POST_QUERY_FIRST_CATEGORY_LIST));
        //初始化获取二级行业事件
        eventManager.addEvent(new QuerySecondCategoryEvent(EventCode.HTTP_POST_QUERY_SECOND_CATEGORY_LIST));
        //初始化注册企业信息事件
        eventManager.addEvent(new RegisterEnterpriseInfoEvent(EventCode.HTTP_POST_REGISTER_ENTERPRISE));
        //初始化查询企业信息事件
        eventManager.addEvent(new QueryEnterpriseInfoEvent(EventCode.HTTP_GET_QUERY_ENTERPRISE_INFO));
        //初始化更新企业信息事件
        eventManager.addEvent(new UpdateEnterpriseInfoEvent(EventCode.HTTP_POST_UPDATE_ENTERPRISE_INFO));
        //初始化插叙店铺列表事件
        eventManager.addEvent(new QueryShopListEvent(EventCode.HTTP_POST_QUERY_SHOP_LIST));
        //初始化添加店铺事件
        eventManager.addEvent(new AddShopEvent(EventCode.HTTP_POST_ADD_SHOP));
        //初始化更新店铺事件
        eventManager.addEvent(new UpdateShopInfoEvent(EventCode.HTTP_POST_UPDATE_SHOP_INFO));
        //初始化查询收银员列表事件
        eventManager.addEvent(new QueryShopCashierListEvent(EventCode.HTTP_POST_QUERY_SHOP_CASHIER_LIST));
        //初始化添加收银员事件
        eventManager.addEvent(new AddShopCashierEvent(EventCode.HTTP_POST_ADD_SHOP_CASHIER));
        //初始化更新收银员事件
        eventManager.addEvent(new UpdateShopCashierEvent(EventCode.HTTP_POST_UPDATE_SHOP_CASHIER));
        //初始化删除店铺收银员事件
        eventManager.addEvent(new DeleteShopCashierEvent(EventCode.HTTP_GET_DELETE_SHOP_CASHIER));
        //初始化查询银行卡列表事件
        eventManager.addEvent(new QueryBankListEvent(EventCode.HTTP_POST_QUERY_BANK_LIST));
        //初始化查询提现银行卡列表事件
        eventManager.addEvent(new QueryBindingBankListEvent(EventCode.HTTP_POST_QUERY_BINDING_BANK_LIST));
        //初始化添加提现银行卡列表事件
        eventManager.addEvent(new AddBindingBankEvent(EventCode.HTTP_POST_ADD_BINDING_BANK));
        //初始化删除提现银行卡列表事件
        eventManager.addEvent(new DeleteBindingBankEvent(EventCode.HTTP_GET_DELETE_BANDING_BANK));
        //初始化查询到账金额事件
        eventManager.addEvent(new QueryBanlanceEvent(EventCode.HTTP_GET_QUERY_BANLANCE));
        //初始化提现事件
        eventManager.addEvent(new WithdrawEvent(EventCode.HTTP_POST_QUERY_WITHDRAW));
        //初始化设置提现密码
        eventManager.addEvent(new SetWithdrawPasswordEvent(EventCode.HTTP_POST_SET_WITHDRAW_PASSWORD));
        //初始化查询一级地区列表事件
        eventManager.addEvent(new QueryFirstRegionEvent(EventCode.HTTP_POST_QUERY_FIRST_REGION_LIST));
        //初始化查询下级地区列表事件
        eventManager.addEvent(new QuerySubRegionEvent(EventCode.HTTP_POST_QUERY_SUB_REGION_LIST));
//
//		// 设置事件监听
//		eventManager.addEventListener(EventCode.HTTP_POST_ORDER_CREATE, this, false);

    }

    public static void initImageLoader(Context context) {
        @SuppressWarnings("deprecation")
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).memoryCacheExtraOptions(480, 800)
                // max-width，max-height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)
                        // 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory().memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                        // 你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024).discCacheSize(150 * 1024 * 1024).discCacheFileNameGenerator(new Md5FileNameGenerator())
                        // 将保存的时候的URI名称用MD5加密
                .tasksProcessingOrder(QueueProcessingType.LIFO).discCacheFileCount(100)
                        // 缓存的文件数量
                        // .discCache(new UnlimitedDiscCache(cacheDir))//自定义缓存路径
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()).imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) // connectTimeout-(5s),readTimeout-(30s)超时时间
                        // .writeDebugLogs() // Remove for release app
                .build();// 开始构建
        ImageLoader.getInstance().init(config);
    }

    /**
     * 获取全局Application上下文
     *
     * @return
     */
    public static Context getApplication() {
        return instance.getApplicationContext();
    }

    /**
     * 获取全局Application上下文
     *
     * @return
     */
    public static BaseApplication getApplicationInstance() {
        return instance;
    }

    /**
     * 获取全局ApplicationHandler
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Handler getMainThreadHandler() {
        return instance.handler;
    }

    /**
     * 获取全局Application SharedPreferences对象
     *
     * @return
     */
    public static SharedPreferences getDefaultSharedPreferences() {
        return SharedPreferenceManager.getSharedPreferences(instance);
    }

    /**
     * 获取全局Application LocalShopManager对象
     *
     * @return
     */
    public static LocalDataManager getLocalManager() {
        return LocalDataManager.getsInstance();
    }

    /**
     * 获取全局Application LocalEnterpriseManager对象
     *
     * @return
     */
    public static LocalDataManager getLocalEnterpriseManager() {
        return LocalDataManager.getsInstance();
    }

    /**
     * 获取全局Application VersionManager对象
     *
     * @return
     */
    public static VersionManager getVersionManager() {
        return VersionManager.getsInstance();
    }

    /**
     * 返回超级管理员是否已经登陆过
     *
     * @return
     */
    public static boolean isLogined() {
        return getLocalManager().isSuperManagerHadLogin();
    }

    /**
     * 设置超级管理员是否已经登陆过
     *
     * @return
     */
    public static void setisLogined(boolean isSuperManagerHadLogin) {
        getLocalManager().setSuperManagerHadLogin(isSuperManagerHadLogin);
    }

    /**
     * 返回缓存的pushid
     *
     * @return
     */
    public static String getPushId() {
        return pushId;
    }

    /**
     * 更新pushid
     *
     * @param pushId
     */
    public static void updatePushId(String pushId) {
        LocalDataManager.getsInstance().setPushId(pushId);
    }

    /**
     * 更新mac地址
     *
     * @param macAdress
     */
    public static void updateMacAdress(String macAdress) {
        LocalDataManager.getsInstance().setMacAdress(macAdress);
    }

    /**
     * 返回本地数据管理单元
     *
     * @return
     */
    public static LocalDataManager getEnterpriseManager() {
        return LocalDataManager.getsInstance();
    }

    public static void saveVerison(AppVersion version) {
        VersionManager.getsInstance().setVersion(version);
    }

    /**
     * 必须升级
     * @return
     */
    public static boolean unUseVerison() {
        return CommonUtils.versionUnSupport(CommonUtils.getVersion(), VersionManager.getsInstance().getVersion().getSupportVersion());
    }

    /**
     * 可以升级
     * @return
     */
    public static boolean canUpdate() {
        return CommonUtils.versionUnSupport(CommonUtils.getVersion(), VersionManager.getsInstance().getVersion().getVersion());
    }

    public static Logger getLogger() {
        if (sLogger == null) {
            sLogger = Logger.getLogger(instance.getPackageName());
            sLogger.setLevel(Level.ALL);
            LoggerSystemOutHandler handler = new LoggerSystemOutHandler();
            handler.setLevel(Level.ALL);
            sLogger.addHandler(handler);
        }
        return sLogger;
    }

    @SuppressWarnings("unused")
    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {

        final int eventCode = event.getEventCode();
        // 服务器联通性测试
        // if (eventCode ==
        // EventCode.HTTP_GET_NET_TO_SERVICE_CONNECTION_TEST_EVENT)
        // {
        // final CheckServiceConnectionEvent checkServiceConnectionEvent =
        // (CheckServiceConnectionEvent) event;
        // if (checkServiceConnectionEvent.isNetSuccess())
        // {
        // if (checkServiceConnectionEvent.isOk() &&
        // checkServiceConnectionEvent.getResult().equals("ok"))
        // {
        // AndroidEventManager.getInstance().postEvent(new
        // MobileCashBaseCallbackEvent(EventCode.CALLBACK_SERVICE_CONNECTION_IS_OK),
        // 0);
        // } else
        // {
        // getLogger().log(Level.INFO,
        // ErrorObject.formatError(checkServiceConnectionEvent.getErrorObject()));
        // }
        // }
        // }
    }

    public static void registDevice(long delayMillis, String pushId) {
        BaseApplication.pushId = pushId;
        updatePushId(pushId);
        updateMacAdress(DeviceInfoUtil.getWLANMACAddress(instance));
        DeviceInfoUp deviceObejct = new DeviceInfoUp(AppType.APP_SHOP, CommonUtils.getVersion(), OSType.OS_ANDROID, pushId, DeviceInfoUtil.getWLANMACAddress(instance));
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_POST_REGIST_DEVICE_EVENT, delayMillis, URLUtils.URL_REGIST_DEVICE, deviceObejct);
    }

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void logout() {
        LocalDataManager.getsInstance().clearLocalEnterprise();
        AppDatabaseManager.getInstance().onDestory(getApplicationInstance());
        UserDatebaseManager.getInstance().onDestory(getApplicationInstance());
        // 关闭所有Activity
        if (activities != null) {
            for (Activity activity : activities) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            activities.clear();
            activities = new ArrayList<Activity>();
        }
        // 彻底登出清理所有数据
        // clear all softWare data when exit applicaton
        new DataClearManager().deleteDataWenExit(getApplication());
    }



    /**
     * 重启应用程序
     */
    public static void restartApplication(Context mContext) {
        // // 重新启动程序欢迎界面
        // Intent intent = new Intent(mContext, StartActivity.class);
        // // 设置启动模式，重新启动
        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // mContext.startActivity(intent);
        // // 彻底退出系统
        // android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(10);
    }

    /**
     * 开始定位
     */
    public static void startLocation() {
        if (locationManagerProxy == null) {
            locationManagerProxy = LocationManagerProxy.getInstance(instance);
            locationManagerProxy.requestLocationUpdates(LocationProviderProxy.AMapNetwork, 5000, 10, instance);
        }
    }

    /**
     * 停止定位
     */
    public static void stopLocation() {
        if (locationManagerProxy != null) {
            locationManagerProxy.removeUpdates(instance);
            locationManagerProxy.destory();
            locationManagerProxy = null;
        }
    }

    private void locationed(final AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            setaMapLocation(aMapLocation);
            AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.CALLBACK_Locationed), 0);
            stopLocation();
        }

    }

    public static AMapLocation getaMapLocation() {
        return aMapLocation;
    }

    public static void setaMapLocation(AMapLocation aMapLocation) {
        BaseApplication.aMapLocation = aMapLocation;
    }

    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            locationed(aMapLocation);
        }
    }


    // //将字符串转为Date
    // public static Date parseDate(String str)
    // {
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    // Date startDate = null;
    // try
    // {
    // startDate = sdf.parse(str);
    // } catch (ParseException e)
    // {
    // e.printStackTrace();
    // }
    // return startDate;
    // }

}

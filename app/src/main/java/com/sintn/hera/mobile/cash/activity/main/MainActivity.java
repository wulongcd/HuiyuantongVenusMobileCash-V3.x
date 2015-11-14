package com.sintn.hera.mobile.cash.activity.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.R;
import com.sintn.hera.mobile.cash.URLUtils;
import com.sintn.hera.mobile.cash.activity.base.BaseActivity;
import com.sintn.hera.mobile.cash.activity.enterprisemanager.EnterpriseManagerActivity;
import com.sintn.hera.mobile.cash.activity.main.fragment.CashCreateFragment;
import com.sintn.hera.mobile.cash.activity.main.fragment.CashOrderFragment;
import com.sintn.hera.mobile.cash.activity.main.fragment.FragmentAdapter;
import com.sintn.hera.mobile.cash.entity.conast.AppType;
import com.sintn.hera.mobile.cash.entity.conast.OSType;
import com.sintn.hera.mobile.cash.entity.conast.RoleType;
import com.sintn.hera.mobile.cash.entity.down.ErrorObject;
import com.sintn.hera.mobile.cash.event.MobileCashBaseCallbackEvent;
import com.sintn.hera.mobile.cash.event.MobileCashBaseEvent;
import com.sintn.hera.mobile.cash.event.httpevent.DownloadEvent;
import com.sintn.hera.mobile.cash.event.httpevent.main.QuerylatestAppVersionEvent;
import com.sintn.hera.mobile.cash.manager.ActivityBaseAttribute;
import com.sintn.hera.mobile.cash.manager.AndroidEventManager;
import com.sintn.hera.mobile.cash.utils.common.CommonUtils;
import com.sintn.hera.mobile.cash.utils.common.DialogUtils;
import com.sintn.hera.mobile.cash.widget.dialog.DownLoadingDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 */
@SuppressLint("InflateParams")
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private DownLoadingDialog downLoadingDialog;
    private boolean isFirstLoadToCheckUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addCallbackEventListener(EventCode.DIALOG_CALLBACK_OF_EXIT);
        addCallbackEventListener(EventCode.CALLBACK_DownloadProgress);
        addCallbackEventListener(EventCode.CALLBACK_OF_CANUPDATE_AREYOU_SURE_TO_UPDATE);
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
        initUInterface();
        queryLatestAppversion(true);
    }

    private void initUInterface() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = null;
        View view_for_cashier = findViewById(R.id.nav_view_for_cashier);
        View view_for_boss = findViewById(R.id.nav_view_for_boss);
        if(BaseApplication.getLocalManager().getRoleType() == RoleType.SHOP_MANAGER_BOSS) {
            view_for_boss.setVisibility(View.VISIBLE);
            view_for_cashier.setVisibility(View.GONE);
            navigationView = (NavigationView) view_for_boss;
        } else {
            view_for_cashier.setVisibility(View.VISIBLE);
            view_for_boss.setVisibility(View.GONE);
            navigationView = (NavigationView) view_for_cashier;
        }
        navigationView.setNavigationItemSelectedListener(this);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager();
    }

    private void setupViewPager() {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        List<String> titles = new ArrayList<>();
        titles.add(getString(R.string.mainactivity_of_cash_tab));
        titles.add(getString(R.string.mainactivity_of_order_tab));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new CashCreateFragment());
        fragments.add(new CashOrderFragment());
        FragmentAdapter adapter =
                new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        int id = item.getItemId();
        if (id == R.id.nav_exit) {
            DialogUtils.ShowNormalChioceMessagWithCallbackDialog(this, R.string.confirm_logout, EventCode.DIALOG_CALLBACK_OF_EXIT);
        } else if (R.id.nav_updateSoftware == id) {
            queryLatestAppversion(true);
        } else if(id == R.id.nav_enterpriseManager) {
            EnterpriseManagerActivity.lunch(this);
        } else if(id == R.id.nav_myWallet ) {

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        super.onClick(v);
    }

    @Override
    protected void onInitAttribute(ActivityBaseAttribute ba) {
        super.onInitAttribute(ba);
        ba.setHasNavigationBar(false);
    }

    /**
     * 获取版本
     *
     * @param showDialog
     */
    protected void queryLatestAppversion(boolean showDialog) {

        if (showDialog) {
            DialogUtils.showLoading(this, EventCode.HTTP_GET_APPVERSION_QUERYLATEST);
        }
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTP_GET_APPVERSION_QUERYLATEST, this, true);
        AndroidEventManager.getInstance().postEvent(EventCode.HTTP_GET_APPVERSION_QUERYLATEST, 0, String.format(URLUtils.URL_GET_APPVERSION_QUERYLATEST, AppType.APP_SIMPLE_CASHIER, OSType.OS_ANDROID));
    }

    /**
     * 下载新版本安装包
     *
     * @param downloadUrl
     */
    protected void downLoadNweVersionPackage(String downloadUrl) {
        if (downLoadingDialog == null) {
            downLoadingDialog = new DownLoadingDialog(this);
        }
        downLoadingDialog.show();
        AndroidEventManager.getInstance().addEventListener(EventCode.HTTPGET_Download, this, true);
        AndroidEventManager.getInstance().postEvent(new DownloadEvent(EventCode.HTTPGET_Download), 0, downloadUrl);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        super.onEventRunEnd(event);
        if (EventCode.DIALOG_CALLBACK_OF_EXIT == eventCode) {
            logout();
            return;
        } else if (EventCode.HTTP_GET_APPVERSION_QUERYLATEST == eventCode) {
            DialogUtils.dissMissLoading(EventCode.HTTP_GET_APPVERSION_QUERYLATEST);
            final QuerylatestAppVersionEvent querylatestAppVersionEvent = (QuerylatestAppVersionEvent) event;
            if (querylatestAppVersionEvent.isNetSuccess()) {
                if (querylatestAppVersionEvent.isOk()) {
                    if (querylatestAppVersionEvent.getData() != null) {
                        BaseApplication.saveVerison(querylatestAppVersionEvent.getData());
                        if (BaseApplication.unUseVerison()) {
                            downLoadNweVersionPackage(querylatestAppVersionEvent.getData().getDownloadUrl());
                        } else if (BaseApplication.canUpdate()) {
                            DialogUtils.ShowNormalChioceMessagWithCallbackDialog(this, R.string.show_of_are_you_sure_to_update, EventCode.CALLBACK_OF_CANUPDATE_AREYOU_SURE_TO_UPDATE);
                        } else {
                            if (!isFirstLoadToCheckUpdate)
                                isFirstLoadToCheckUpdate = true;
                            else
                                toastManager.show(R.string.show_of_are_not_need_update);
                        }
                    }
                } else {
                    if (querylatestAppVersionEvent.getErrorObject() == null) {
                        toastManager.show(querylatestAppVersionEvent.getStrHttpResult());
                    } else {
                        toastManager.show(ErrorObject.formatError(querylatestAppVersionEvent.getErrorObject()));
                    }
                }
            } else {

            }
        } else if (eventCode == EventCode.HTTPGET_Download) {
            final DownloadEvent downloadEvetn = (DownloadEvent) event;
            if (downloadEvetn.isNetSuccess()) {
                if (downloadEvetn.isOk()) {
                    if (downLoadingDialog != null) {
                        downLoadingDialog.dismiss();
                    }
                    //安装APK
                    CommonUtils.install(this);
                } else {
                    if (downLoadingDialog != null) {
                        downLoadingDialog.dismiss();
                    }
                }
            } else {
                if (downLoadingDialog != null) {
                    downLoadingDialog.dismiss();
                }
                if (downloadEvetn.getErrorObject() == null) {
                    toastManager.show(downloadEvetn.getStrHttpResult());
                } else {
                    toastManager.show(ErrorObject.formatError(downloadEvetn.getErrorObject()));
                }
            }
            return;
        } else if (eventCode == EventCode.CALLBACK_DownloadProgress) {
            MobileCashBaseCallbackEvent callbackEvent = (MobileCashBaseCallbackEvent) event;
            final Integer progress = (Integer) callbackEvent.getReturnParam();
            if (downLoadingDialog != null) {
                downLoadingDialog.updateProgress(progress);
            }
            return;
        } else if (eventCode == EventCode.CALLBACK_OF_CANUPDATE_AREYOU_SURE_TO_UPDATE) {
            downLoadNweVersionPackage(BaseApplication.getVersionManager().getVersion().getDownloadUrl());
            return;
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            onBackPressedAsHomePressed();
        }

    }

    @Override
    protected void onBackPressedAsHomePressed() {
        // TODO Auto-generated method stub
        super.onBackPressedAsHomePressed();
    }


    public static void launch(Activity activity) {
        if (!CommonUtils.isActivityAreRunningBefore(activity, MainActivity.class)) {
            Intent intent = new Intent(activity, MainActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        removeCallbackEventListener(EventCode.DIALOG_CALLBACK_OF_EXIT);
        removeCallbackEventListener(EventCode.CALLBACK_DownloadProgress);
        removeCallbackEventListener(EventCode.CALLBACK_OF_CANUPDATE_AREYOU_SURE_TO_UPDATE);
        super.onDestroy();
    }

}

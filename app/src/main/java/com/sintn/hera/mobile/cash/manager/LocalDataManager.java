package com.sintn.hera.mobile.cash.manager;

import android.content.SharedPreferences;

import com.sintn.hera.mobile.cash.BaseApplication;
import com.sintn.hera.mobile.cash.entity.conast.RoleType;
import com.sintn.hera.mobile.cash.entity.up.LoginForCashierAppUp;

/**
 * @Desc: 本地数据管理器
 * @com.sintn.hera.mobile.cash.manager
 * @HuiyuantongVenusMobileCash-V3.x
 * @LocalDataManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:11:39
 */
public class LocalDataManager {
    //本地数据管理器单例对象
    private static LocalDataManager instance;
    //是否登录标志
    private boolean isSuperManagerHadLogin;
    //时间戳
    private long modifyDate;
    // 网络回话标志
    private String jsessionId;
    //网络推送标志
    private String pushId;
    //本机MAC地址
    private String macAdress;
    // 用户名称
    private String username;
    // 密码
    private String password;
    //sp实例
    private SharedPreferences sp;
    //登录角色
    private int roleType;

    public static LocalDataManager getsInstance() {
        if (instance == null) {
            instance = new LocalDataManager();
        }
        return instance;
    }

    public LocalDataManager() {
        sp = BaseApplication.getDefaultSharedPreferences();
        // enterpriseSettingDown = new EnterpriseSettingDown(sp);
        // enterprise = new Enterprise(sp);
        isSuperManagerHadLogin = sp.getBoolean(SharedPreferenceManager.KEY_isSuperManagerHadLogin, false);
        jsessionId = sp.getString(SharedPreferenceManager.KEY_jsessionId, null);
        pushId = sp.getString(SharedPreferenceManager.KEY_pushId, null);
        macAdress = sp.getString(SharedPreferenceManager.KEY_macAddress, null);
        modifyDate = sp.getLong(SharedPreferenceManager.KEY_MODIFYDATE, 0);
        username = sp.getString(SharedPreferenceManager.KEY_username, null);
        password = sp.getString(SharedPreferenceManager.KEY_md5psd, null);
        roleType = sp.getInt(SharedPreferenceManager.KEY_ROLE_TYPE, RoleType.SHOP_MANAGER);
    }

    /**
     * 返回时间戳
     *
     * @return
     */
    public long getModifyDate() {
        return modifyDate;
    }

    /**
     * 保存时间戳
     *
     * @param modifyDate
     */
    public void saveModifyDate(long modifyDate) {
        SharedPreferences.Editor et = sp.edit();
        et.putLong(SharedPreferenceManager.KEY_MODIFYDATE, modifyDate);
        et.commit();
        this.modifyDate = modifyDate;
    }

    /**
     * 返回网络回话标志
     *
     * @return
     */
    public String getJsessionId() {
        return jsessionId;
    }

    /**
     * 保存网络回话标志
     *
     * @param jsessionId
     */
    public void setJsessionId(String jsessionId) {
        this.jsessionId = jsessionId;
        SharedPreferences.Editor et = sp.edit();
        et.putString(SharedPreferenceManager.KEY_jsessionId, jsessionId);
        et.commit();
    }

    /**
     * 返回网络推送标志
     *
     * @return
     */
    public String getPushId() {
        return pushId;
    }

    /**
     * 保存网络推送标志
     *
     * @param pushId
     */
    public void setPushId(String pushId) {
        this.pushId = pushId;
        SharedPreferences.Editor et = sp.edit();
        et.putString(SharedPreferenceManager.KEY_pushId, pushId);
        et.commit();
    }

    /**
     * 返回本机MAC地址
     *
     * @return
     */
    public String getMacAdress() {
        return macAdress;
    }

    /**
     * 保存本机MAC地址
     *
     * @param macAdress
     */
    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
        SharedPreferences.Editor et = sp.edit();
        et.putString(SharedPreferenceManager.KEY_macAddress, macAdress);
        et.commit();
    }

    /**
     * 返回是否登录标志
     *
     * @return
     */
    public boolean isSuperManagerHadLogin() {
        return isSuperManagerHadLogin;
    }

    /**
     * 保存是否登录标志
     *
     * @param isSuperManagerHadLogin
     */
    public void setSuperManagerHadLogin(boolean isSuperManagerHadLogin) {
        this.isSuperManagerHadLogin = isSuperManagerHadLogin;
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean(SharedPreferenceManager.KEY_isSuperManagerHadLogin, isSuperManagerHadLogin);
        et.commit();
    }

    /**
     * @return
     */
    public LoginForCashierAppUp getLoginForCashierAppUp() {
        return new LoginForCashierAppUp(username, password);
    }

    /**
     * @param username
     * @param password
     */
    public void saveLoginForCashierAppUp(String username, String password) {
        this.username = username;
        this.password = password;
        SharedPreferences.Editor et = sp.edit();
        et.putString(SharedPreferenceManager.KEY_username, username);
        et.putString(SharedPreferenceManager.KEY_md5psd, password);
        et.commit();
    }

    /**
     * 获取登录角色
     * @return 登录角色类型
     */
    public int getRoleType() {
        return roleType;
    }

    /**
     * 设置登录角色
     * @param roleType 登录角色类型
     */
    public void setRoleType(int roleType) {
        this.roleType = roleType;
        sp.edit().putInt(SharedPreferenceManager.KEY_ROLE_TYPE, roleType).commit();
    }

    /**
     * 清除数据
     */
    public void clearLocalEnterprise() {
        SharedPreferences.Editor et = sp.edit();
        et.clear();
        et.commit();
        this.modifyDate = 0;
        this.jsessionId = null;
        this.macAdress = null;
        this.isSuperManagerHadLogin = false;
        this.username = null;
        this.password = null;
        this.roleType = RoleType.SHOP_MANAGER;
    }
}

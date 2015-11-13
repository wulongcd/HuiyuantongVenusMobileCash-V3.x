package com.sintn.hera.mobile.cash.entity.down;

import android.content.SharedPreferences;

import com.sintn.hera.mobile.cash.manager.SharedPreferenceManager;

import java.util.Date;


/**
 * App的版本
 */
public class AppVersion {
    private Long id;
    private Date createDate;
    private long modifyDate;
    private boolean deleted;

    // 版本
    private String version;

    // 支持的最低版本
    private String supportVersion;

    // app的类型：参见AppType类
    private int appType;

    // os的类型：参见OsType类型
    private int osType;

    // App的状态：参见AppStatus类
    private int status;

    // app下载地址
    private String downloadUrl;

    // 描述
    private String description;

    public AppVersion() {
    }

    public AppVersion(SharedPreferences sp) {
        this.id = sp.getLong(SharedPreferenceManager.KEY_versionId, -1L);
        this.deleted = sp.getBoolean(SharedPreferenceManager.KEY_versionDeleted, false);
        this.version = sp.getString(SharedPreferenceManager.KEY_versionVersion, null);
        this.supportVersion = sp.getString(SharedPreferenceManager.KEY_versionSupportVersion, null);
        this.appType = sp.getInt(SharedPreferenceManager.KEY_versionAppType, 0);
        this.osType = sp.getInt(SharedPreferenceManager.KEY_versionOsType, 0);
        this.status = sp.getInt(SharedPreferenceManager.KEY_versionStatus, 0);
        this.description = sp.getString(SharedPreferenceManager.KEY_versionDescription, null);
        this.downloadUrl = sp.getString(SharedPreferenceManager.KEY_versionDownloadUrl, null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSupportVersion() {
        return supportVersion;
    }

    public void setSupportVersion(String supportVersion) {
        this.supportVersion = supportVersion;
    }

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public int getOsType() {
        return osType;
    }

    public void setOsType(int osType) {
        this.osType = osType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

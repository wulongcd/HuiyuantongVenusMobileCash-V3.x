package com.sintn.hera.mobile.cash.entity.up;

public class DeviceInfoUp
{
	// App的类型，参见AppType类
	private int appType;

	// App的版本
	private String appVersion;

	// 设备的OS类型，参见OSType类
	private int osType;

	// 设备的推送ID
	private String pushId;

	// 设备的mac地址
	private String macAddress;

	public DeviceInfoUp(int appType, String appVersion, int osType, String pushId, String macAddress)
	{
		super();
		this.appType = appType;
		this.appVersion = appVersion;
		this.osType = osType;
		this.pushId = pushId;
		this.macAddress = macAddress;
	}

	public int getAppType()
	{
		return appType;
	}

	public void setAppType(int appType)
	{
		this.appType = appType;
	}

	public String getAppVersion()
	{
		return appVersion;
	}

	public void setAppVersion(String appVersion)
	{
		this.appVersion = appVersion;
	}

	public int getOsType()
	{
		return osType;
	}

	public void setOsType(int osType)
	{
		this.osType = osType;
	}

	public String getPushId()
	{
		return pushId;
	}

	public void setPushId(String pushId)
	{
		this.pushId = pushId;
	}

	public String getMacAddress()
	{
		return macAddress;
	}

	public void setMacAddress(String macAddress)
	{
		this.macAddress = macAddress;
	}

}

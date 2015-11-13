package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: boss相关信息下行实体
 * @com.sintn.hera.mobile.cash.entity.down
 * @HuiyuantongVenusMobileCash-V3.x
 * @AccountRelatedInfoDown.java
 * @Author:Wxl@Sintn.Inc
 * @2015-7-3下午1:49:21
 */
public class AccountRelatedInfoDown
{
	/**
	 * Boss头像，仅仅是图片的文件名称，格式*.*
	 */
	private String logo;

	/**
	 * 绑定的手机
	 */
	private String bindingPhone;

	/**
	 * 钱包余额
	 * 
	 */
	private BalanceDown balance;
	/**
	 * 未读通知的数量
	 * 
	 */
	private int unreadCount;
	/**
	 * 软件最新版本
	 */
	private AppVersion appVersion;

	public String getLogo()
	{
		return logo;
	}

	public void setLogo(String logo)
	{
		this.logo = logo;
	}

	public String getBindingPhone()
	{
		return bindingPhone;
	}

	public void setBindingPhone(String bindingPhone)
	{
		this.bindingPhone = bindingPhone;
	}

	public BalanceDown getBalance()
	{
		return balance;
	}

	public void setBalance(BalanceDown balance)
	{
		this.balance = balance;
	}

	public int getUnreadCount()
	{
		return unreadCount;
	}

	public void setUnreadCount(int unreadCount)
	{
		this.unreadCount = unreadCount;
	}

	public AppVersion getAppVersion()
	{
		return appVersion;
	}

	public void setAppVersion(AppVersion appVersion)
	{
		this.appVersion = appVersion;
	}

}

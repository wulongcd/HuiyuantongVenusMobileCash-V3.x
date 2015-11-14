package com.sintn.hera.mobile.cash.entity.down;

/**
 * 
 * @Desc: 登录的上行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:04:49
 */
public class StaffValiDown
{

	//是否有该员工账号
	private boolean hasAccount=false;
	
	//是否是第一次登陆
	private boolean firstLogin=false;
	
	//员工账户ID，如果hasAccount=true时，大于0
	private long id;

	public StaffValiDown()
	{
		super();
	}

	public StaffValiDown(boolean hasAccount, boolean firstLogin, long id)
	{
		super();
		this.hasAccount = hasAccount;
		this.firstLogin = firstLogin;
		this.id = id;
	}

	public boolean isHasAccount()
	{
		return hasAccount;
	}

	public void setHasAccount(boolean hasAccount)
	{
		this.hasAccount = hasAccount;
	}

	public boolean isFirstLogin()
	{
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin)
	{
		this.firstLogin = firstLogin;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
	
	public String toString() {
		String str = "";
		str += "isHasAccount=" + isHasAccount()+"\n";
		str += "isFirstLogin=" + isFirstLogin()+"\n";
		str += "id=" + getId()+"\n";
		return str;
	}

}

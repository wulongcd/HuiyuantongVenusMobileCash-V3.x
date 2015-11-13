package com.sintn.hera.mobile.cash.entity.up;

/**
 * 
 * @Desc: 更新密码的上行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @UpdatePasswordUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:06:12
 */
public class UpdatePasswordUp
{
	// 旧密码
	private String oldPasswd;

	// 新密码
	private String newPasswd;

	public UpdatePasswordUp(String oldPasswd, String newPasswd)
	{
		super();
		this.oldPasswd = oldPasswd;
		this.newPasswd = newPasswd;
	}

	public String getOldPasswd()
	{
		return oldPasswd;
	}

	public void setOldPasswd(String oldPasswd)
	{
		this.oldPasswd = oldPasswd;
	}

	public String getNewPasswd()
	{
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd)
	{
		this.newPasswd = newPasswd;
	}
}

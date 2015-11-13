package com.sintn.hera.mobile.cash.entity.down;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Desc: 登录的下行实体
 * @com.sintn.hera.mobile.cash.entity.up
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUp.java
 * @Author:Wxl@Sintn.Inc
 * @2015-8-4下午6:04:49
 */
@SuppressWarnings("serial")
public class StaffLoginDown implements Serializable
{

	//账号列表
	private List<LoginDown> datas;

	public StaffLoginDown()
	{
		super();
	}

	public StaffLoginDown(List<LoginDown> datas)
	{
		super();
		this.datas = datas;
	}

	public List<LoginDown> getDatas()
	{
		return datas;
	}

	public void setDatas(List<LoginDown> datas)
	{
		this.datas = datas;
	}

}

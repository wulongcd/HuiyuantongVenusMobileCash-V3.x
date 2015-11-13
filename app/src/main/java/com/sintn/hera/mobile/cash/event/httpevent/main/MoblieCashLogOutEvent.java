package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;


/**
 * 
 * @Desc: 登出操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LogOutEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:09
 */
public class MoblieCashLogOutEvent extends HttpGetEvent
{
	private String result;

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public MoblieCashLogOutEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT && isOk && !isMethodNotAllowed())
		{
			result = strHttpResult;
		}
	}

}

package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;


/**
 * 
 * @Desc: 注册账户（通知服务器改账户已经登录）
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LogOutEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:09
 */
public class RegisterAccountEvent extends HttpGetEvent
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

	public RegisterAccountEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_GET_REGIST_ACCOUNT_EVENT && isOk && !isMethodNotAllowed())
		{
			result = strHttpResult;
		}
	}

}

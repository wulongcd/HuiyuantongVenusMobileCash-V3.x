package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.StaffValiDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 登陆操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class VerifyAccountUpEvent extends HttpPostEvent
{

	private StaffValiDown result;


	public StaffValiDown getResult()
	{
		return result;
	}

	public void setResult(StaffValiDown result)
	{
		this.result = result;
	}

	public VerifyAccountUpEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_VERIFY_ACCOUNT_EVENT && isOk && !isMethodNotAllowed())
		{
			result = (StaffValiDown) JsonCommonUtils.jsonToObject(strHttpResult, StaffValiDown.class);
		}
	}

}

package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.StaffLoginDown;
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
public class SetPasswordUpEvent extends HttpPostEvent
{

	private StaffLoginDown result;

	public StaffLoginDown getResult()
	{
		return result;
	}

	public void setResult(StaffLoginDown result)
	{
		this.result = result;
	}

	public SetPasswordUpEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_SET_PASSWORD_EVENT && isOk && !isMethodNotAllowed())
		{
			result = (StaffLoginDown) JsonCommonUtils.jsonToObject(strHttpResult, StaffLoginDown.class);
		}
	}

}

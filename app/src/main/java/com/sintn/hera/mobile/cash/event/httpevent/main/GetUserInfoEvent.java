package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.ShopStaffDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 获取验证码操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class GetUserInfoEvent extends HttpGetEvent
{

	private ShopStaffDown result;

	public ShopStaffDown getResult()
	{
		return result;
	}

	public void setResult(ShopStaffDown result)
	{
		this.result = result;
	}

	public GetUserInfoEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_GET_QUERYUSERINFO && isOk && !isMethodNotAllowed())
		{
			result = (ShopStaffDown) JsonCommonUtils.jsonToObject(strHttpResult, ShopStaffDown.class);
		}
	}

}

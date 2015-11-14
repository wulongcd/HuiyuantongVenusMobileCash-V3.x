package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;


/**
 * 
 * @com.sintn.hera.shop.event.httpevent.expend
 * @HuiyuantongVenusShopCash-V3.x
 * @ExpendNormalRecordsQueryEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc:
 * @2015-4-7上午11:07:12
 */
public class ApplictionErrorUpLoadEvent extends HttpPostEvent
{
	private String result = null;

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}

	public ApplictionErrorUpLoadEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_APPLICTION_ERROR && isOk && !isMethodNotAllowed())
		{
			result = strHttpResult;
		}
	}

}

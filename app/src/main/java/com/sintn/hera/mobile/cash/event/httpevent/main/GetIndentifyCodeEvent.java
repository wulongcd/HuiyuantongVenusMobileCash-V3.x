package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;

/**
 * 
 * @Desc: 投诉查询
 * @com.sintn.hera.mobile.cash.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21QUERYPERFORMANCE_RESULTS
 */
public class GetIndentifyCodeEvent extends HttpPostEvent
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

	public GetIndentifyCodeEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_GETIDENTIFYINGCODE && isOk && !isMethodNotAllowed())
		{
			result = strHttpResult;
		}
	}
}

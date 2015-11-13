package com.sintn.hera.mobile.cash.event.httpevent.main;


import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.AppVersion;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 套餐详情查询
 * @com.sintn.hera.mobile.cash.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21QUERYPERFORMANCE_RESULTS
 */
public class GetVersionEvent extends HttpGetEvent
{

	private AppVersion result = null;

	public AppVersion getResult()
	{
		return result;
	}

	public void setResult(AppVersion result)
	{
		this.result = result;
	}

	public GetVersionEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_GET_QUERYVERSION && isOk && !isMethodNotAllowed())
		{
			result = (AppVersion) JsonCommonUtils.jsonToObject(strHttpResult, AppVersion.class);
		}
	}

}

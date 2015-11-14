package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.PerformanceDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 业绩查询
 * @com.sintn.hera.mobile.cash.event.httpevent.user
 * @HuiyuantongVenusWorkerAssistant-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21QUERYPERFORMANCE_RESULTS
 */
public class QueryPerformanceResultsEvent extends HttpPostEvent
{

	private PerformanceDown result = null;

	public PerformanceDown getResult()
	{
		return result;
	}

	public void setResult(PerformanceDown result)
	{
		this.result = result;
	}

	public QueryPerformanceResultsEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERYPERFORMANCE_RESULTS && isOk && !isMethodNotAllowed())
		{
			result = (PerformanceDown) JsonCommonUtils.jsonToObject(strHttpResult, PerformanceDown.class);
		}
	}

}

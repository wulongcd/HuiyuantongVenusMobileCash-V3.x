package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.assistant.EventCode;
import com.sintn.hera.assistant.entity.down.OnlinePayOrderForBossDownRealDown;
import com.sintn.hera.assistant.event.httpevent.HttpPostEvent;
import com.sintn.hera.assistant.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 查询钱包收入记录
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusBossAssistant-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21QUERYPERFORMANCE_RESULTS
 */
public class QueryOnlinePayOrWithdrawOrderResultsEvent extends HttpPostEvent
{

	private OnlinePayOrderForBossDownRealDown result = null;

	public OnlinePayOrderForBossDownRealDown getResult()
	{
		return result;
	}

	public void setResult(OnlinePayOrderForBossDownRealDown result)
	{
		this.result = result;
	}

	public QueryOnlinePayOrWithdrawOrderResultsEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERYONLINEPAYORDER && isOk && !isMethodNotAllowed())
		{
			result = (OnlinePayOrderForBossDownRealDown) JsonCommonUtils.jsonToObject(strHttpResult, OnlinePayOrderForBossDownRealDown.class);
		}
	}
}

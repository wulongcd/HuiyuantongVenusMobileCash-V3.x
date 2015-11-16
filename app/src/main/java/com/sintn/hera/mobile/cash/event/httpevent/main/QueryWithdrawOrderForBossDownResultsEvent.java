package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.assistant.EventCode;
import com.sintn.hera.assistant.entity.down.WithdrawOrderForBossDownRealDown;
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
public class QueryWithdrawOrderForBossDownResultsEvent extends HttpPostEvent
{

	private WithdrawOrderForBossDownRealDown result = null;

	public WithdrawOrderForBossDownRealDown getResult()
	{
		return result;
	}

	public void setResult(WithdrawOrderForBossDownRealDown result)
	{
		this.result = result;
	}

	public QueryWithdrawOrderForBossDownResultsEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERYWITHDRAWORDER && isOk && !isMethodNotAllowed())
		{
			result = (WithdrawOrderForBossDownRealDown) JsonCommonUtils.jsonToObject(strHttpResult, WithdrawOrderForBossDownRealDown.class);
		}
	}
}

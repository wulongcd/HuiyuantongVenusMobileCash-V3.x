package com.sintn.hera.mobile.cash.event.httpevent.cash;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;

/**
 * 
 * @Desc: 提现操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class WithdrawEvent extends HttpPostEvent
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

	public WithdrawEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERY_WITHDRAW && isOk && !isMethodNotAllowed())
		{
			result = strHttpResult;
		}
	}

}

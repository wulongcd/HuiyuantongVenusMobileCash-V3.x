package com.sintn.hera.mobile.cash.event.httpevent.cash;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.BalanceForCashierAppDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 查询企业到账金额操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class QueryBanlanceEvent extends HttpPostEvent
{

	private BalanceForCashierAppDown result;

	public BalanceForCashierAppDown getResult()
	{
		return result;
	}

	public void setResult(BalanceForCashierAppDown result)
	{
		this.result = result;
	}

	public QueryBanlanceEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_GET_QUERY_BANLANCE && isOk && !isMethodNotAllowed())
		{
			result = (BalanceForCashierAppDown) JsonCommonUtils.jsonToObject(strHttpResult, BalanceForCashierAppDown.class);
		}
	}

}

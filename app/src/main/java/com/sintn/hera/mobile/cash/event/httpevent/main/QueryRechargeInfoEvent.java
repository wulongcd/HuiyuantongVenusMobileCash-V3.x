package com.sintn.hera.mobile.cash.event.httpevent.main;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.RechargeDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 充值详情查询
 * @com.sintn.hera.mobile.cash.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21QUERYPERFORMANCE_RESULTS
 */
public class QueryRechargeInfoEvent extends HttpGetEvent
{

	private RechargeDown result = null;

	public RechargeDown getResult()
	{
		return result;
	}

	public void setResult(RechargeDown result)
	{
		this.result = result;
	}

	public QueryRechargeInfoEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_GET_QUERYRECHARGE_INFO && isOk && !isMethodNotAllowed())
		{
			result = (RechargeDown) JsonCommonUtils.jsonToObject(strHttpResult, RechargeDown.class);
		}
	}

}

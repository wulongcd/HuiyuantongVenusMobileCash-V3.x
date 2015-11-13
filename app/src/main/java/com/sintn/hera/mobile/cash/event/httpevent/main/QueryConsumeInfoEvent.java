package com.sintn.hera.mobile.cash.event.httpevent.main;


import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.ConsumeStaffDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 消费详情查询
 * @com.sintn.hera.mobile.cash.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21QUERYPERFORMANCE_RESULTS
 */
public class QueryConsumeInfoEvent extends HttpGetEvent
{

	private ConsumeStaffDown result = null;

	public ConsumeStaffDown getResult()
	{
		return result;
	}

	public void setResult(ConsumeStaffDown result)
	{
		this.result = result;
	}

	public QueryConsumeInfoEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_GET_QUERYCONSUME_INFO && isOk && !isMethodNotAllowed())
		{
			result = (ConsumeStaffDown) JsonCommonUtils.jsonToObject(strHttpResult, ConsumeStaffDown.class);
		}
	}

}

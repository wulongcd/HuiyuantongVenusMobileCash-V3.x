package com.sintn.hera.mobile.cash.event.httpevent.cash;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.EnterpriseForCashierAppDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpGetEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 查询企业信息操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class QueryEnterpriseInfoEvent extends HttpGetEvent
{

	private EnterpriseForCashierAppDown result;

	public EnterpriseForCashierAppDown getResult()
	{
		return result;
	}

	public void setResult(EnterpriseForCashierAppDown result)
	{
		this.result = result;
	}

	public QueryEnterpriseInfoEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_GET_QUERY_ENTERPRISE_INFO && isOk && !isMethodNotAllowed())
		{
			result = (EnterpriseForCashierAppDown) JsonCommonUtils.jsonToObject(strHttpResult, EnterpriseForCashierAppDown.class);
		}
	}

}

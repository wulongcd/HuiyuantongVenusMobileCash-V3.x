package com.sintn.hera.mobile.cash.event.httpevent.main;

import java.util.Arrays;
import java.util.List;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.PagerDown;
import com.sintn.hera.mobile.cash.entity.down.SaleStatisDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

/**
 * 
 * @Desc: 店铺查询
 * @com.sintn.hera.mobile.cash.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21QUERYPERFORMANCE_RESULTS
 */
public class QueryStatisticEvent extends HttpPostEvent
{

	private PagerDown<SaleStatisDown> result = null;

	public PagerDown<SaleStatisDown> getResult()
	{
		return result;
	}

	public void setResult(PagerDown<SaleStatisDown> result)
	{
		this.result = result;
	}

	public QueryStatisticEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERYSTATISTICS_RESULTS && isOk && !isMethodNotAllowed())
		{
			result = (PagerDown<SaleStatisDown>) JsonCommonUtils.jsonToObject(strHttpResult, PagerDown.class);
			List<SaleStatisDown> list = Arrays.asList((SaleStatisDown[]) JsonCommonUtils.jsonToObject(result.getDatas().toString(), SaleStatisDown[].class));
			result.setDatas(list);
		}
	}

}

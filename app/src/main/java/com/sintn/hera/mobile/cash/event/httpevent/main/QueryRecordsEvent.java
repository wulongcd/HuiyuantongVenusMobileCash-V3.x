package com.sintn.hera.mobile.cash.event.httpevent.main;

import java.util.Arrays;
import java.util.List;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.DividedStaffDown;
import com.sintn.hera.mobile.cash.entity.down.PagerDown;
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
public class QueryRecordsEvent extends HttpPostEvent
{

	private PagerDown<DividedStaffDown> result = null;

	public PagerDown<DividedStaffDown> getResult()
	{
		return result;
	}

	public void setResult(PagerDown<DividedStaffDown> result)
	{
		this.result = result;
	}

	public QueryRecordsEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERYRECOED_RESULTS && isOk && !isMethodNotAllowed())
		{
			result = (PagerDown<DividedStaffDown>) JsonCommonUtils.jsonToObject(strHttpResult, PagerDown.class);
			List<DividedStaffDown> list = Arrays.asList((DividedStaffDown[]) JsonCommonUtils.jsonToObject(result.getDatas().toString(), DividedStaffDown[].class));
			result.setDatas(list);
//			for(int i=0;i<result.getDatas().size();i++) {
//				DividedStaffDown DividedStaffDown = JsonCommonUtils.jsonToObject(result.getDatas().get(i), DividedStaffDown.class);
//			}
		}
	}

}

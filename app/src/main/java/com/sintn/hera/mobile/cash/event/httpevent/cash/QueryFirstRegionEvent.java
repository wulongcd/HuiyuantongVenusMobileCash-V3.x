package com.sintn.hera.mobile.cash.event.httpevent.cash;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.RegionForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @Desc: 查询一级地区列表操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class QueryFirstRegionEvent extends HttpPostEvent
{

	private CommonPagerDown<RegionForCashierAppDown> result;

	public CommonPagerDown<RegionForCashierAppDown> getResult()
	{
		return result;
	}

	public void setResult(CommonPagerDown<RegionForCashierAppDown> result)
	{
		this.result = result;
	}

	public QueryFirstRegionEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERY_FIRST_REGION_LIST && isOk && !isMethodNotAllowed())
		{
			result = (CommonPagerDown<RegionForCashierAppDown>) JsonCommonUtils.jsonToObject(strHttpResult, CommonPagerDown.class);
			List<RegionForCashierAppDown> list = Arrays.asList((RegionForCashierAppDown[]) JsonCommonUtils.jsonToObject(result.getList().toString(), RegionForCashierAppDown[].class));
			result.setList(list);
		}
	}

}

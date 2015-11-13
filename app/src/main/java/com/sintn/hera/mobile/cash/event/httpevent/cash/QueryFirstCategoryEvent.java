package com.sintn.hera.mobile.cash.event.httpevent.cash;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.CategoryForCashierAppDown;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @Desc: 查询一级行业列表操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class QueryFirstCategoryEvent extends HttpPostEvent
{

	private CommonPagerDown<CategoryForCashierAppDown> result;

	public CommonPagerDown<CategoryForCashierAppDown> getResult()
	{
		return result;
	}

	public void setResult(CommonPagerDown<CategoryForCashierAppDown> result)
	{
		this.result = result;
	}

	public QueryFirstCategoryEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERY_FIRST_CATEGORY_LIST && isOk && !isMethodNotAllowed())
		{
			result = (CommonPagerDown<CategoryForCashierAppDown>) JsonCommonUtils.jsonToObject(strHttpResult, CommonPagerDown.class);
			List<CategoryForCashierAppDown> list = Arrays.asList((CategoryForCashierAppDown[]) JsonCommonUtils.jsonToObject(result.getList().toString(), CategoryForCashierAppDown[].class));
			result.setList(list);
		}
	}

}

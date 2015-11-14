package com.sintn.hera.mobile.cash.event.httpevent.cash;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.ShopManagerAccountForCashierAppDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @Desc: 查询店铺收银员列表操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class QueryShopCashierListEvent extends HttpPostEvent
{

	private CommonPagerDown<ShopManagerAccountForCashierAppDown> result;

	public CommonPagerDown<ShopManagerAccountForCashierAppDown> getResult()
	{
		return result;
	}

	public void setResult(CommonPagerDown<ShopManagerAccountForCashierAppDown> result)
	{
		this.result = result;
	}

	public QueryShopCashierListEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERY_SHOP_CASHIER_LIST && isOk && !isMethodNotAllowed())
		{
			result = (CommonPagerDown) JsonCommonUtils.jsonToObject(strHttpResult, CommonPagerDown.class);
			List<ShopManagerAccountForCashierAppDown> list = Arrays.asList((ShopManagerAccountForCashierAppDown[]) JsonCommonUtils.jsonToObject(result.getList().toString(), ShopManagerAccountForCashierAppDown[].class));
			result.setList(list);
		}
	}

}

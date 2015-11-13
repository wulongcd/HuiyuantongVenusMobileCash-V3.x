package com.sintn.hera.mobile.cash.event.httpevent.cash;

import com.sintn.hera.mobile.cash.EventCode;
import com.sintn.hera.mobile.cash.entity.down.CommonPagerDown;
import com.sintn.hera.mobile.cash.entity.down.BindingBankCardForCashierAppDown;
import com.sintn.hera.mobile.cash.event.httpevent.HttpPostEvent;
import com.sintn.hera.mobile.cash.utils.core.JsonCommonUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @Desc: 查询提现银行卡列表操作网络事件
 * @com.sintn.hera.assistant.event.httpevent.user
 * @HuiyuantongVenusMobileCash-V3.x
 * @LoginUpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-29下午3:42:21
 */
public class QueryBindingBankListEvent extends HttpPostEvent
{

	private CommonPagerDown<BindingBankCardForCashierAppDown> result;

	public CommonPagerDown<BindingBankCardForCashierAppDown> getResult()
	{
		return result;
	}

	public void setResult(CommonPagerDown<BindingBankCardForCashierAppDown> result)
	{
		this.result = result;
	}

	public QueryBindingBankListEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		if (eventCode == EventCode.HTTP_POST_QUERY_BINDING_BANK_LIST && isOk && !isMethodNotAllowed())
		{
			result = (CommonPagerDown) JsonCommonUtils.jsonToObject(strHttpResult, CommonPagerDown.class);
			List<BindingBankCardForCashierAppDown> list = Arrays.asList((BindingBankCardForCashierAppDown[]) JsonCommonUtils.jsonToObject(result.getList().toString(), BindingBankCardForCashierAppDown[].class));
			result.setList(list);
		}
	}

}

package com.sintn.hera.mobile.cash.event.httpevent;

import com.sintn.hera.mobile.cash.utils.core.HttpDefaultUtils;

/**
 * 
 * @Desc: 网络获取事件
 * @com.sintn.hera.mobile.cash.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpDefaultGetEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-5-19下午3:10:18
 */

public class HttpDefaultGetEvent extends HttpEvent
{

	public HttpDefaultGetEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		httpResponse = HttpDefaultUtils.doGet(strUrl);
		verifyResponse();
	}
}

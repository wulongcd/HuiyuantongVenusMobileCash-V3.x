package com.sintn.hera.mobile.cash.event.httpevent;

import com.sintn.hera.mobile.cash.utils.core.HttpUtils;

/**
 * 
 * @com.sintn.hera.mobile.cash.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpPutEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: http->put事件
 * @2015-2-4下午4:02:20
 */
public class HttpPutEvent extends HttpEvent
{

	public HttpPutEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Object... params) throws Exception
	{
		super.run(params);
		httpResponse = HttpUtils.doPut(strUrl, params[1]);
		verifyResponse();
	}

}
